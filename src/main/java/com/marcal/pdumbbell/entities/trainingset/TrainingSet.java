package com.marcal.pdumbbell.entities.trainingset;

import com.marcal.pdumbbell.core.enums.WeightMetric;
import com.marcal.pdumbbell.entities.BaseEntity;
import com.marcal.pdumbbell.entities.exercise.ExerciseSession;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "training_set" )
public class TrainingSet extends BaseEntity<Long> {

    @Column( name = "weight" )
    private int weight;

    @Column( name = "metric" )
    @Enumerated( EnumType.STRING )
    private WeightMetric metric;

    @Column( name = "reps_qty" )
    private int reps;

    @ManyToOne
    @JoinColumn( name = "exercise_session_id" )
    private ExerciseSession session;

    public TrainingSet( long id, int weight, WeightMetric metric, int reps ) {
        super( id );
        this.weight = weight;
        this.metric = metric;
        this.reps = reps;
    }

    public TrainingSet( ) {
    }
}
