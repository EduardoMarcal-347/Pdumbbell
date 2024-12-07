package com.marcal.pdumbbell.entities.converters;

import com.marcal.pdumbbell.utils.UUIDBinarySerializer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter( autoApply = true )
public class UUIDToByteArrayConverter implements AttributeConverter<UUID, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn( UUID uuid ) {
        if ( uuid == null ) {
            return null;
        }
        byte[] uuidBytes = com.marcal.pdumbbell.utils.UUIDBinarySerializer.uuidToBytes( uuid );
        return UUIDBinarySerializer.orderedUuid( uuidBytes );
    }

    @Override
    public UUID convertToEntityAttribute( byte[] bytes ) {
        if ( bytes == null || bytes.length != 16 ) {
            return null;
        }
        return UUIDBinarySerializer.bytesToUuid( bytes );
    }

}