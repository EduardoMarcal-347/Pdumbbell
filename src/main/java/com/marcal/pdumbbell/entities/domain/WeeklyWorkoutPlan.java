package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "weekly_workout_plan")
public class WeeklyWorkoutPlan extends BaseEntity<Long> {

    @OneToOne
    @JoinColumn( name = "user_id" )
    private User user;

    @ManyToOne
    @JoinColumn( name = "monday_workout")
    private WorkoutTemplate mondayWorkout;

    @ManyToOne
    @JoinColumn( name = "tuesday_workout")
    private WorkoutTemplate tuesdayWorkout;

    @ManyToOne
    @JoinColumn( name = "wednesday_workout")
    private WorkoutTemplate wednesdayWorkout;

    @ManyToOne
    @JoinColumn( name = "thursday_workout")
    private WorkoutTemplate thursdayWorkout;

    @ManyToOne
    @JoinColumn( name = "friday_workout")
    private WorkoutTemplate fridayWorkout;

    @ManyToOne
    @JoinColumn( name = "saturday_workout")
    private WorkoutTemplate saturdayWorkout;

    @ManyToOne
    @JoinColumn( name = "sunday_workout")
    private WorkoutTemplate sundayWorkout;

}
