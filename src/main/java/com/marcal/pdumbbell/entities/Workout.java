package com.marcal.pdumbbell.entities;

import com.marcal.pdumbbell.core.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "workout_name")
    private String name;

    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @OneToMany(mappedBy = "workout")
    private List<ExerciseSession> exercises;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "last_modified")
    private Instant lastModified;

    public Workout(long id, String name, DayOfWeek dayOfWeek, List<ExerciseSession> exercises, String description, Instant createdAt, Instant lastModified) {
        this.id = id;
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
        this.description = description;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public Workout() {
    }

}
