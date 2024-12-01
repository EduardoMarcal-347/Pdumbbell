package com.marcal.pdumbbell.entities.workout;

import com.marcal.pdumbbell.core.enums.DayOfWeek;
import com.marcal.pdumbbell.entities.BaseEntity;
import com.marcal.pdumbbell.entities.exercise.ExerciseSession;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "workout" )
public class Workout extends BaseEntity<Long> {

    @Column( name = "workout_name" )
    private String name;

    @Column( name = "day_of_week" )
    @Enumerated( EnumType.STRING )
    private DayOfWeek dayOfWeek;

    @OneToMany( mappedBy = "workout" )
    private List<ExerciseSession> exercises;

    @Column( name = "description" )
    private String description;

    public Workout( Long id, String name, DayOfWeek dayOfWeek, List<ExerciseSession> exercises, String description ) {
        super( id );
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
        this.description = description;
    }

    public Workout( ) {
    }

}
