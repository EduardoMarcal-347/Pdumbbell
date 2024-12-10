package com.marcal.pdumbbell.dto.mappers.response.user;

import com.marcal.pdumbbell.dto.mappers.response.UserResponseMapper;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRequestMapperTests {

    @Test
    public void testToDto() {
        User entity = new User( );
        entity.setFullname( "Domiscleude Gomes da Silva" );
        entity.setEmail( "test@gmail.com" );
        entity.setPhoneNumber( "70707070" );

        UserResponseDTO responseDTO = UserResponseMapper.INSTANCE.toDto( entity );
        assertNotNull( responseDTO );
        assertEquals( entity.getFullname(), responseDTO.getFullname() );
        assertEquals( entity.getEmail(), responseDTO.getEmail() );
        assertEquals(entity.getPhoneNumber(), responseDTO.getPhoneNumber() );
    }
}
