package com.marcal.pdumbbell.entities;

import com.marcal.pdumbbell.core.enums.DayOfWeek;

import java.time.Instant;
import java.util.List;

public class Workout {

    private DayOfWeek dayOfWeek;
    private List<ExerciseSession> exercises;
    private String description;
    private Instant createdDate;

}
