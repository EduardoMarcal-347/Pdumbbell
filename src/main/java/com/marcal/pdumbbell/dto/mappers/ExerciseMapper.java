package com.marcal.pdumbbell.dto.mappers;

import com.marcal.pdumbbell.dto.common.ExerciseDTO;
import com.marcal.pdumbbell.entities.Exercise;
import org.mapstruct.factory.Mappers;

public interface ExerciseMapper extends MapperStruct<Exercise, ExerciseDTO> {
    ExerciseMapper INSTANCE = Mappers.getMapper( ExerciseMapper.class );
}
