package com.marcal.pdumbbell.dto.mappers.file;

import com.marcal.pdumbbell.dto.common.file.FileMetadataDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.entities.file.FileMetadata;
import org.mapstruct.factory.Mappers;

public interface FileMetadataMapper extends MapperStruct<FileMetadata, FileMetadataDTO> {
    FileMetadataMapper INSTANCE = Mappers.getMapper( FileMetadataMapper.class );
}
