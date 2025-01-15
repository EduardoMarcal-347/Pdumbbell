package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "exercise_session_template" )
public class ExerciseSessionTemplate extends BaseEntity<Long> {

    private String identifier;

    private int qtySets;

    @ManyToOne()
    @JoinColumn( name = "exercise_id" )
    private Exercise exercise;

    public ExerciseSessionTemplate( Long id, String identifier, int qtySets, Exercise exercise ) {
        super( id );
        this.identifier = identifier;
        this.qtySets = qtySets;
        this.exercise = exercise;
    }

    public ExerciseSessionTemplate( ) { }
}
