package com.marcal.pdumbbell.dto.common.exercise;

import com.marcal.pdumbbell.dto.common.file.FileMetadataDTO;

public record ExerciseDTO(
        String name,
        String description,
        String tutorialUrl,
        FileMetadataDTO image,
        String targetMuscles
) { }
