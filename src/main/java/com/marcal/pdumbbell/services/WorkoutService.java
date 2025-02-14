package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.rest.request.WorkoutTemplateReqDTO;
import com.marcal.pdumbbell.dto.rest.shared.BaseResponse;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.entities.domain.Workout;
import com.marcal.pdumbbell.repositories.WorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    private ResponseEntity<BaseResponse> createWorkout( Workout workout, User owner) {
        return null;
    }

    private ResponseEntity<BaseResponse> createWorkoutTemplate( User creator, WorkoutTemplateReqDTO template ) {
        return null;
    }

}
