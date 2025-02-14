package com.marcal.pdumbbell.dto.rest.request;

import com.marcal.pdumbbell.dto.common.SessionTemplateDTO;
import com.marcal.pdumbbell.entities.domain.TargetMuscle;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record WorkoutTemplateReqDTO(
        @NotBlank(message = "Username/Email must not be null.")
        String name,

        String description,

        @NotBlank(message = "Username/Email must not be null.")
        List<SessionTemplateDTO> exercises,

        List<TargetMuscle> targetMuscles
) { }
