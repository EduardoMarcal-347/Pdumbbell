package com.marcal.pdumbbell.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exercise_session")
public class ExerciseSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    private List<TrainingSet> sets;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public ExerciseSession(long id, Exercise exercise, List<TrainingSet> sets) {
        this.id = id;
        this.exercise = exercise;
        this.sets = sets;
    }

    public ExerciseSession() {
    }

}
