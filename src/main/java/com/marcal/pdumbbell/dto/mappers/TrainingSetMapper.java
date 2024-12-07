package com.marcal.pdumbbell.dto.mappers;

import com.marcal.pdumbbell.dto.common.TrainingSetDTO;
import com.marcal.pdumbbell.entities.domain.TrainingSet;
import org.mapstruct.factory.Mappers;

public interface TrainingSetMapper extends MapperStruct<TrainingSet, TrainingSetDTO> {
    TrainingSetMapper INSTANCE = Mappers.getMapper( TrainingSetMapper.class );
}
