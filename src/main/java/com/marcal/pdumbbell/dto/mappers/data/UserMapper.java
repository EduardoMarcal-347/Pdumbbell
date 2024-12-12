package com.marcal.pdumbbell.dto.mappers.data;

import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.entities.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends MapperStruct<User, UserDTO> {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
}
