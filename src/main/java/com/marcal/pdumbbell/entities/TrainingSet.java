package com.marcal.pdumbbell.entities;

import com.marcal.pdumbbell.core.enums.WeightMetric;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "training_set")
public class TrainingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "metric")
    @Enumerated(EnumType.STRING)
    private WeightMetric metric;

    @Column(name = "reps_qty")
    private int reps;

    @ManyToOne
    @JoinColumn(name = "exercise_session_id")
    private ExerciseSession session;

    public TrainingSet(long id, int weight, WeightMetric metric, int reps) {
        this.id = id;
        this.weight = weight;
        this.metric = metric;
        this.reps = reps;
    }

    public TrainingSet() {
    }
}
