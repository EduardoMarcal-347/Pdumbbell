package com.marcal.pdumbbell.entities.exercise;

import com.marcal.pdumbbell.entities.BaseEntity;
import com.marcal.pdumbbell.entities.trainingset.TrainingSet;
import com.marcal.pdumbbell.entities.workout.Workout;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "exercise_session" )
public class ExerciseSession extends BaseEntity<Long> {

    @ManyToOne()
    @JoinColumn( name = "exercise_id" )
    private Exercise exercise;

    @OneToMany( mappedBy = "session", fetch = FetchType.EAGER )
    private List<TrainingSet> sets;

    @ManyToOne
    @JoinColumn( name = "workout_id" )
    private Workout workout;

    public ExerciseSession( Long id, Exercise exercise, List<TrainingSet> sets ) {
        super( id );
        this.exercise = exercise;
        this.sets = sets;
    }

    public ExerciseSession( ) {
    }

}
