package com.marcal.pdumbbell.dto.mappers.rest;

import com.marcal.pdumbbell.dto.mappers.impl.rest.UserRestMapper;
import com.marcal.pdumbbell.dto.rest.response.UserResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserRestMapperTests {

    @Test
    public void testToDto() {
        User entity = new User( );
        entity.setFullname( "Domiscleude Gomes da Silva" );
        entity.setEmail( "test@gmail.com" );
        entity.setPhoneNumber( "70707070" );

        UserResponseDTO responseDTO = UserRestMapper.INSTANCE.toDto( entity );
        assertNotNull( responseDTO );
        assertEquals( entity.getFullname(), responseDTO.getFullname() );
        assertEquals( entity.getEmail(), responseDTO.getEmail() );
        assertEquals(entity.getPhoneNumber(), responseDTO.getPhoneNumber() );
    }
}
