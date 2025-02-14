package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
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

    public Exercise( String name, String description, String tutorialUrl, FileMetadata image, String targetMuscles ) {
        this.name = name;
        this.description = description;
        this.tutorialUrl = tutorialUrl;
        this.image = image;
        this.targetMuscles = targetMuscles;
    }

    public Exercise( ) {
    }

}
