package com.marcal.pdumbbell.dto.common.exercise;

import com.marcal.pdumbbell.dto.common.trainingset.TrainingSetDTO;
import com.marcal.pdumbbell.dto.common.workout.WorkoutDTO;

import java.util.List;

public record ExerciseSessionDTO(
    ExerciseDTO exercise,
    List<TrainingSetDTO> sets,
    WorkoutDTO workout
) { }
