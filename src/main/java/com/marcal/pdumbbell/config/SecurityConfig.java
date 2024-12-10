package com.marcal.pdumbbell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .csrf( csrf -> csrf
                        .csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse( ) )
                        .disable()
                )
                .authorizeHttpRequests( authorizeConfig -> {
                    authorizeConfig.requestMatchers( "dumbbell/auth/**" ).permitAll( )
                            .anyRequest( ).authenticated( );
                } )
                .formLogin(formLogin -> formLogin
                        .loginPage("/dumbbell/auth/login")
                        .permitAll()
                );

        return http.build( );
    }
}