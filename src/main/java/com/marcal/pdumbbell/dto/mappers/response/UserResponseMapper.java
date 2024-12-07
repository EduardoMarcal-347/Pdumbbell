package com.marcal.pdumbbell.dto.mappers.response;

import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper extends MapperStruct<User, UserResponseDTO> {
    UserResponseMapper INSTANCE = Mappers.getMapper( UserResponseMapper.class);
}
