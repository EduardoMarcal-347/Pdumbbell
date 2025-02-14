package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import com.marcal.pdumbbell.entities.enums.Muscle;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table( name = "target_muscle" )
public class TargetMuscle extends BaseEntity<Long> {

    @Column( name = "muscle" )
    @Enumerated( EnumType.STRING )
    private Muscle name;

    public TargetMuscle( Muscle name ) {
        this.name = name;
    }

    public TargetMuscle( ) {
    }
}
