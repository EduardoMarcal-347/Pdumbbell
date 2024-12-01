package com.marcal.pdumbbell.dto.common;

import com.marcal.pdumbbell.enums.DayOfWeek;

import java.util.List;

public record WorkoutDTO(
        String name,
        DayOfWeek dayOfWeek,
        List<ExerciseSessionDTO> exercises,
        String Description
) { }
