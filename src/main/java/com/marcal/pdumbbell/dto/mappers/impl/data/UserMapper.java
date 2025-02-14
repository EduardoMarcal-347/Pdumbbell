package com.marcal.pdumbbell.dto.mappers.impl.data;

import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.mappers.BaseMapper;
import com.marcal.pdumbbell.entities.domain.User;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
}
