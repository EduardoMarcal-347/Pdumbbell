package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "workout" )
public class Workout extends BaseEntity<Long> {

    @Column( name = "workout_name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @Column( name = "workout_performed_at" )
    private Instant workoutPerformedAt;

    @OneToMany( mappedBy = "workout" )
    private List<ExerciseSession> exercises;

    @ManyToOne
    @JoinColumn( name = "workout_template_id" )
    private WorkoutTemplate workoutTemplate;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private User user;

    public Workout( Long id, String name, String description, Instant workoutPerformedAt, List<ExerciseSession> exercises, WorkoutTemplate workoutTemplate, User user ) {
        super( id );
        this.name = name;
        this.description = description;
        this.workoutPerformedAt = workoutPerformedAt;
        this.exercises = exercises;
        this.workoutTemplate = workoutTemplate;
        this.user = user;
    }

    public Workout( ) { }

}
