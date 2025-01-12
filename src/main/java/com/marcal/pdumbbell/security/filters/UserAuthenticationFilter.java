package com.marcal.pdumbbell.security.filters;

import com.marcal.pdumbbell.dto.mappers.data.UserMapper;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.security.auth.UserDetailsImpl;
import com.marcal.pdumbbell.security.service.JWTokenService;
import com.marcal.pdumbbell.services.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    private final JWTokenService jwTokenService;

    private final AuthService authService;

    public UserAuthenticationFilter( JWTokenService jwTokenService, AuthService authService ) {
        this.jwTokenService = jwTokenService;
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        if ( !isURIPublic( request ) ) {
            String token = recoveryToken( request );
            if ( token != null ) {
                String subject = jwTokenService.getSubjectFromToken( token );
                User user = authService.loadByIdentifier( subject )
                        .orElseThrow( ( ) -> new RuntimeException( "Couldn´t load user by token subject" ) );

                UserDetailsImpl details = new UserDetailsImpl( user );
                Authentication authentication = new UsernamePasswordAuthenticationToken( UserMapper.INSTANCE.toDto( user ), null, details.getAuthorities( ) );
                SecurityContextHolder.getContext( ).setAuthentication( authentication );
            } else {
                throw new RuntimeException( "Token not found." );
            }
        }
        filterChain.doFilter( request, response );
    }

    private String recoveryToken( HttpServletRequest request ) {
        String authorizationHeader = request.getHeader( "Authorization" );
        if ( authorizationHeader != null ) {
            return authorizationHeader.replace( "Bearer", "" ).trim( );
        }
        return null;
    }

    private boolean isURIPublic( HttpServletRequest request ) {
        return request.getRequestURI( ).contains( "auth" );
    }
}
