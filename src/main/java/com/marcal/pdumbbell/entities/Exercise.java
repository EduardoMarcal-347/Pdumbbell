package com.marcal.pdumbbell.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "exercise" )
public class Exercise extends BaseEntity<Long> {

    @Column( name = "exercise_name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @Column( name = "tutorial_url" )
    private String tutorialUrl;

    @ManyToOne()
    @JoinColumn( name = "image_id" )
    private FileMetadata image;

    @Column( name = "target_muscles" )
    private String targetMuscles;

    public Exercise( Long id, String name, String description, String tutorialUrl, FileMetadata image, String targetMuscles ) {
        super( id );
        this.name = name;
        this.description = description;
        this.tutorialUrl = tutorialUrl;
        this.image = image;
        this.targetMuscles = targetMuscles;
    }

    public Exercise( ) {
    }

}
