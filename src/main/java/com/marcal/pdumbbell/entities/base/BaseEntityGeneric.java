package com.marcal.pdumbbell.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public abstract class BaseEntityGeneric implements Serializable {

    @CreatedDate
    @Column( name = "created_at" )
    private Instant createdAt;

    @LastModifiedDate
    @Column( name = "last_modified" )
    private Instant lastModified;

    @Version
    private long version;

    protected BaseEntityGeneric( ) { }
}
