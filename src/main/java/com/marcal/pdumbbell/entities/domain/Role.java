package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntity;
import com.marcal.pdumbbell.entities.enums.AccessRole;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "access_role")
public class Role extends BaseEntity<Long> {

    @Enumerated( EnumType.STRING)
    @Column(name = "role")
    private AccessRole name;

    public Role( Long id, AccessRole name ) {
        super( id );
        this.name = name;
    }

    public Role( ) {
    }
}
