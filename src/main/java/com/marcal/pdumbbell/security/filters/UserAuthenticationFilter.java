package com.marcal.pdumbbell.security.filters;

import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.security.auth.UserDetailsImpl;
import com.marcal.pdumbbell.security.service.JWTokenService;
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

    private JWTokenService jwTokenService;

    private final UserRepository userRepository;

    public UserAuthenticationFilter( JWTokenService jwTokenService, UserRepository userRepository ) {
        this.jwTokenService = jwTokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        if ( !isURIPublic( request ) ) {
            String token = recoveryToken( request );
            if ( token != null ) {
                String subject = jwTokenService.getSubjectFromToken( token );
                User user = userRepository.findByUsername( subject );
                UserDetailsImpl details = new UserDetailsImpl( user );

                Authentication authentication = new UsernamePasswordAuthenticationToken( details.getUsername(), null, details.getAuthorities() );
                SecurityContextHolder.getContext().setAuthentication( authentication );
            } else {
                throw new RuntimeException( "Token not found." );
            }
        }
        filterChain.doFilter( request, response );
    }

    private String recoveryToken( HttpServletRequest request ) {
        String authorizationHeader = request.getHeader( "Authorization" );
        if ( authorizationHeader != null ) {
            return authorizationHeader.replace( "Bearer", "" );
        }
        return null;
    }

    private boolean isURIPublic( HttpServletRequest request ) {
        return request.getRequestURI( ).contains( "auth" );
    }
}
