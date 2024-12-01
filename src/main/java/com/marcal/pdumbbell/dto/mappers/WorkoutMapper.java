package com.marcal.pdumbbell.dto.mappers;

import com.marcal.pdumbbell.dto.common.WorkoutDTO;
import com.marcal.pdumbbell.entities.Workout;
import org.mapstruct.factory.Mappers;

public interface WorkoutMapper extends MapperStruct<Workout, WorkoutDTO> {
    ExerciseMapper INSTANCE = Mappers.getMapper( ExerciseMapper.class );
}
