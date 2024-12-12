package com.marcal.pdumbbell.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Service
public class JWTokenService {

    private final String SECRET_KEY;

    private final String ISSUER = "pdumbbell-api";

    public JWTokenService( @Value( "${spring.security.jwt.secret-key}" ) String SECRET_KEY ) {
        this.SECRET_KEY = SECRET_KEY;
    }

    public String generateToken( UserDetails details ) {
        try {
            return JWT.create( )
                    .withIssuer( ISSUER )
                    .withIssuedAt( getIssuedAt( ) )
                    .withExpiresAt( getExpiresAt( ) )
                    .withSubject( details.getUsername( ) )
                    .sign( Algorithm.HMAC256( SECRET_KEY ) );
        } catch ( JWTCreationException e ) {
            throw new JWTCreationException( "Error while trying to generate token", e );
        }
    }

    public String getSubjectFromToken( String token ) {
        try {
            return JWT.require( Algorithm.HMAC256( SECRET_KEY ) )
                    .withIssuer( ISSUER )
                    .build( )
                    .verify( token )
                    .getSubject( );
        } catch ( JWTVerificationException e ) {
            throw new JWTVerificationException( "Error while trying to verify token: invalid or expired", e );
        }
    }

    private Instant getIssuedAt( ) {
        return ZonedDateTime.now( ZoneOffset.UTC ).toInstant( );
    }


    private Instant getExpiresAt( ) {
        return ZonedDateTime.now( ZoneOffset.UTC ).plusHours( 5 ).toInstant( );
    }

}
