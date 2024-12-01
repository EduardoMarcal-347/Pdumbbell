package com.marcal.pdumbbell.dto.common;

import java.util.List;

public record ExerciseSessionDTO(
    ExerciseDTO exercise,
    List<TrainingSetDTO> sets,
    WorkoutDTO workout
) { }
