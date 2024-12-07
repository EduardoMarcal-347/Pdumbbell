package com.marcal.pdumbbell.dto.common;

import com.marcal.pdumbbell.entities.enums.WeightMetric;

public record TrainingSetDTO(
        int weight,
        WeightMetric metric,
        int reps,
        ExerciseSessionDTO session
) { }
