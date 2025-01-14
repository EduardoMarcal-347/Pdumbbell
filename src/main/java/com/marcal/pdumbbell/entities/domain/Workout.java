package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import com.marcal.pdumbbell.entities.enums.DayOfWeek;
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

    @Column( name = "description" )
    private String description;

    @Column( name = "day_of_week" )
    @Enumerated( EnumType.STRING )
    private DayOfWeek dayOfWeek;

    @OneToMany( mappedBy = "workout" )
    private List<ExerciseSession> exercises;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @JoinTable( name = "workout_target_muscles",
            joinColumns = @JoinColumn( name = "workout_id" ),
            inverseJoinColumns = @JoinColumn( name = "target_muscle_id" ) )
    private List<TargetMuscle> targetMuscles;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private User user;

    public Workout( Long id, String name, DayOfWeek dayOfWeek, List<ExerciseSession> exercises, String description, User user ) {
        super( id );
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
        this.description = description;
        this.user = user;
    }

    public Workout( ) { }

}
