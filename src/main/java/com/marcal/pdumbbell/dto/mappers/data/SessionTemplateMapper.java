package com.marcal.pdumbbell.dto.mappers.data;

import com.marcal.pdumbbell.dto.common.SessionTemplateDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.entities.domain.ExerciseSessionTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionTemplateMapper extends MapperStruct<ExerciseSessionTemplate, SessionTemplateDTO> {
    SessionTemplateMapper INSTANCE = Mappers.getMapper(SessionTemplateMapper.class);
}
