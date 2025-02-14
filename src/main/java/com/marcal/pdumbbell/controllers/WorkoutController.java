package com.marcal.pdumbbell.controllers;

import com.marcal.pdumbbell.common.annotation.AuthenticatedUser;
import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.rest.request.WorkoutTemplateReqDTO;
import com.marcal.pdumbbell.dto.rest.shared.BaseResponse;
import com.marcal.pdumbbell.services.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/pdumbbell/api/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create( @AuthenticatedUser UserDTO owner) {
        return null;
    }

    @PostMapping("/template")
    public ResponseEntity<BaseResponse> createTemplate( @AuthenticatedUser UserDTO creator, @Validated WorkoutTemplateReqDTO template){
        return null;
    }
}
