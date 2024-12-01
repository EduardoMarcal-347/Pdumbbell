package com.marcal.pdumbbell.dto.mappers.trainingset;

import com.marcal.pdumbbell.dto.common.trainingset.TrainingSetDTO;
import com.marcal.pdumbbell.dto.mappers.MapperStruct;
import com.marcal.pdumbbell.entities.trainingset.TrainingSet;
import org.mapstruct.factory.Mappers;

public interface TrainingSetMapper extends MapperStruct<TrainingSet, TrainingSetDTO> {
    TrainingSetMapper INSTANCE = Mappers.getMapper( TrainingSetMapper.class );
}
