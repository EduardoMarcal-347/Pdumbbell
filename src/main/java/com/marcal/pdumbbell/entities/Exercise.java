package com.marcal.pdumbbell.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tutorialUrl")
    private String tutorialUrl;

    @ManyToOne()
    @JoinColumn(name = "image_id")
    private FileMetadata image;

    @Column(name = "target_muscles")
    private String targetMuscles;

    public Exercise(long id, String name, String description, String tutorialUrl, FileMetadata image, String targetMuscles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tutorialUrl = tutorialUrl;
        this.image = image;
        this.targetMuscles = targetMuscles;
    }

    public Exercise() {
    }

}
