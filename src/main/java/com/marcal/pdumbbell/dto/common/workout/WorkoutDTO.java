package com.marcal.pdumbbell.dto.common.workout;

import com.marcal.pdumbbell.core.enums.DayOfWeek;
import com.marcal.pdumbbell.dto.common.exercise.ExerciseSessionDTO;

import java.util.List;

public record WorkoutDTO(
        String name,
        DayOfWeek dayOfWeek,
        List<ExerciseSessionDTO> exercises,
        String Description
) { }
