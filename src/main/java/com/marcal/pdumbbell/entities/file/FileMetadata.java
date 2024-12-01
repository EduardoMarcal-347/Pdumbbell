package com.marcal.pdumbbell.entities.file;

import com.marcal.pdumbbell.core.enums.FileStatus;
import com.marcal.pdumbbell.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "file_metadata" )
public class FileMetadata extends BaseEntity<Long> {

    @Column( name = "file_name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @Column( name = "mime_type" )
    private String mimeType;

    @Column( name = "extension" )
    private String extension;

    @Column( name = "size" )
    private int size;

    @Column( name = "location" )
    private String location;

    //    @ManyToOne()
//    @JoinColumn(name = "owner_id")
    private String ownerId;

    @Column( name = "status" )
    @Enumerated( EnumType.STRING )
    private FileStatus status;

    @Column( name = "checksum" )
    private String checksum;


    public FileMetadata( Long id, String name, String description, String mimeType, String extension, int size, String location, String ownerId, FileStatus status, String checksum ) {
        super( id );
        this.name = name;
        this.description = description;
        this.mimeType = mimeType;
        this.extension = extension;
        this.size = size;
        this.location = location;
        this.ownerId = ownerId;
        this.status = status;
        this.checksum = checksum;
    }

    public FileMetadata( ) {
    }

}
