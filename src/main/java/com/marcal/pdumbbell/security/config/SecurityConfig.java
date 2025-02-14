package com.marcal.pdumbbell.security.config;

import com.marcal.pdumbbell.security.filters.UserAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationFilter authenticationFilter;

    public SecurityConfig( UserAuthenticationFilter authenticationFilter ) {
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .csrf( csrf -> csrf
                        .csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse( ) )
                        .disable()
                )
                .authorizeHttpRequests( authorizeConfig -> authorizeConfig.requestMatchers( "/auth/**" ).permitAll( )
                        .anyRequest( ).authenticated( ) )
                .addFilterBefore( authenticationFilter, UsernamePasswordAuthenticationFilter.class );

        return http.build( );
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}