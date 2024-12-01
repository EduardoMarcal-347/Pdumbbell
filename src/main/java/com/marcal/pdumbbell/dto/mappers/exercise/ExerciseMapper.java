package com.marcal.pdumbbell.dto.mappers.exercise;

import com.marcal.pdumbbell.dto.common.exercise.ExerciseDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.entities.exercise.Exercise;
import org.mapstruct.factory.Mappers;

public interface ExerciseMapper extends MapperStruct<Exercise, ExerciseDTO> {
    ExerciseMapper INSTANCE = Mappers.getMapper( ExerciseMapper.class );
}
