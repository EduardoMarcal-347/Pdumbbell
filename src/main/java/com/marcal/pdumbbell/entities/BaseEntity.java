package com.marcal.pdumbbell.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public abstract class BaseEntity<T> implements Serializable {

    @Id
    private T id;

    @CreatedDate
    @Column( name = "created_at" )
    private Instant createdAt;

    @LastModifiedDate
    @Column( name = "last_modified" )
    private Instant lastModified;

    @Version
    private long version;

    public BaseEntity( T id ) {
        this.id = id;
    }

    protected BaseEntity( ) {
    }
}
