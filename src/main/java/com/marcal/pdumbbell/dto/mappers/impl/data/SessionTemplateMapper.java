package com.marcal.pdumbbell.dto.mappers.impl.data;

import com.marcal.pdumbbell.dto.common.SessionTemplateDTO;
import com.marcal.pdumbbell.dto.mappers.BaseMapper;
import com.marcal.pdumbbell.entities.domain.ExerciseSessionTemplate;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface SessionTemplateMapper extends BaseMapper<ExerciseSessionTemplate, SessionTemplateDTO> {
    SessionTemplateMapper INSTANCE = Mappers.getMapper(SessionTemplateMapper.class);
}
