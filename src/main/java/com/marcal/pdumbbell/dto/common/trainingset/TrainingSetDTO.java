package com.marcal.pdumbbell.dto.common.trainingset;

import com.marcal.pdumbbell.core.enums.WeightMetric;
import com.marcal.pdumbbell.dto.common.exercise.ExerciseSessionDTO;

public record TrainingSetDTO(
        int weight,
        WeightMetric metric,
        int reps,
        ExerciseSessionDTO session
) { }
