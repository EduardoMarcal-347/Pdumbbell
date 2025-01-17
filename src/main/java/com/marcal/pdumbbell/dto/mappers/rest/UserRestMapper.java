package com.marcal.pdumbbell.dto.mappers.rest;

import com.marcal.pdumbbell.dto.mappers.RestMapper;
import com.marcal.pdumbbell.dto.request.UserRequestDTO;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRestMapper extends RestMapper<User, UserRequestDTO, UserResponseDTO> {
    UserRestMapper INSTANCE = Mappers.getMapper( UserRestMapper.class );
}
