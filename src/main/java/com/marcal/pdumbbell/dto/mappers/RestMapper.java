package com.marcal.pdumbbell.dto.mappers;

import org.mapstruct.MappingTarget;

public interface RestMapper<E, Request, Response> {

    Response toDto(E entity);
    E toEntity(Request dto);
    E updateEntity( @MappingTarget E entity, Request dto);

}
