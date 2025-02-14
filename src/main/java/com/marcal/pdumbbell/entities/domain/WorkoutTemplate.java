package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "workout_template" )
public class WorkoutTemplate extends BaseEntity<Long> {

    @Column( name = "template_name" )
    private String name;

    private String description;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @JoinTable( name = "workout_exercise_template",
            joinColumns = @JoinColumn( name = "workout_template_id" ),
            inverseJoinColumns = @JoinColumn( name = "exercise_session_template_id" ) )
    private List<ExerciseSessionTemplate> exercises;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @JoinTable( name = "workout_target_muscles",
            joinColumns = @JoinColumn( name = "workout_template_id" ),
            inverseJoinColumns = @JoinColumn( name = "target_muscle_id" ) )
    private List<TargetMuscle> targetMuscles;

    @ManyToOne( cascade = CascadeType.ALL )
    private User creator;

    public WorkoutTemplate( String name, String description, List<ExerciseSessionTemplate> exercises, List<TargetMuscle> targetMuscles, User creator ) {
        this.name = name;
        this.description = description;
        this.exercises = exercises;
        this.targetMuscles = targetMuscles;
        this.creator = creator;
    }

    public WorkoutTemplate( ) {
    }

}
