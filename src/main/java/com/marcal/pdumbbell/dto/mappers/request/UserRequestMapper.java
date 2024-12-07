package com.marcal.pdumbbell.dto.mappers.request;

import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.dto.request.UserRequestDTO;
import com.marcal.pdumbbell.entities.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper extends MapperStruct<User, UserRequestDTO> {
    UserRequestMapper INSTANCE = Mappers.getMapper( UserRequestMapper.class);
}
