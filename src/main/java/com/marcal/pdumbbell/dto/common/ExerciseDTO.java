package com.marcal.pdumbbell.dto.common;

public record ExerciseDTO(
        String name,
        String description,
        String tutorialUrl,
        FileMetadataDTO image,
        String targetMuscles
) { }
