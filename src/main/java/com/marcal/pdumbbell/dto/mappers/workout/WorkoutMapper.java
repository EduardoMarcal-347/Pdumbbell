package com.marcal.pdumbbell.dto.mappers.workout;

import com.marcal.pdumbbell.dto.common.workout.WorkoutDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.dto.mappers.exercise.ExerciseMapper;
import com.marcal.pdumbbell.entities.workout.Workout;
import org.mapstruct.factory.Mappers;

public interface WorkoutMapper extends MapperStruct<Workout, WorkoutDTO> {
    ExerciseMapper INSTANCE = Mappers.getMapper( ExerciseMapper.class );
}
