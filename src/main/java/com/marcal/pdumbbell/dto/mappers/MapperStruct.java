package com.marcal.pdumbbell.dto.mappers;

import org.mapstruct.MappingTarget;

public interface MapperStruct<E, D> {

    D toDto(E entity);
    E toEntity(D dto);
    E updateEntity(@MappingTarget E entity, D dto);

}