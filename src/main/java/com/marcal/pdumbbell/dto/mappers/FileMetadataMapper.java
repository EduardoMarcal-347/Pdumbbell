package com.marcal.pdumbbell.dto.mappers;

import com.marcal.pdumbbell.dto.common.FileMetadataDTO;
import com.marcal.pdumbbell.entities.domain.FileMetadata;
import org.mapstruct.factory.Mappers;

public interface FileMetadataMapper extends MapperStruct<FileMetadata, FileMetadataDTO> {
    FileMetadataMapper INSTANCE = Mappers.getMapper( FileMetadataMapper.class );
}
