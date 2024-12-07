package com.marcal.pdumbbell.entities.base;

import com.marcal.pdumbbell.entities.converters.UUIDToByteArrayConverter;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class)
public abstract class BaseEntityUUID extends BaseEntityGeneric {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Convert(converter = UUIDToByteArrayConverter.class)
    private UUID id;

    public BaseEntityUUID( ) { }

    public BaseEntityUUID( UUID id ) {
        this.id = id;
    }
}
