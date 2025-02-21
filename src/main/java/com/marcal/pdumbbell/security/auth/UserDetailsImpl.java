package com.marcal.pdumbbell.security.auth;

import com.marcal.pdumbbell.entities.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl( User user ) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( ) {
        return user.getRoles( )
                .stream( )
                .map( role -> new SimpleGrantedAuthority( role.getName( ).name( ) ) )
                .collect( Collectors.toList( ) );
    }

    @Override
    public String getPassword( ) {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername( ) {
        return user.getUsername( );
    }
}
