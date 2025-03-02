package com.marcal.pdumbbell.dto.common;

public record FileMetadataDTO (
        String name,
        String description,
        String mimeType,
        String extension,
        int size,
        String location,
        String ownerId,
        String checksum
) { }
