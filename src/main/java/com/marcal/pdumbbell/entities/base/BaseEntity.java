package com.marcal.pdumbbell.entities.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class)
public abstract class BaseEntity<T> extends BaseEntityGeneric {

    @Id
    private T id;

    protected BaseEntity( ) { }

    protected BaseEntity( T id ) {
        this.id = id;
    }

}
