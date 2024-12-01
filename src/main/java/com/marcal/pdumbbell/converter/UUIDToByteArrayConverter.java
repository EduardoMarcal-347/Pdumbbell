package com.marcal.pdumbbell.converter;

import com.marcal.pdumbbell.core.utils.UUIDBinarySerializer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class UUIDToByteArrayConverter implements AttributeConverter<UUID, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(UUID uuid) {
        if (uuid == null) {
            return null;
        }
        byte[] uuidBytes = UUIDBinarySerializer.uuidToBytes(uuid);
        return UUIDBinarySerializer.orderedUuid(uuidBytes);
    }

    @Override
    public UUID convertToEntityAttribute(byte[] bytes) {
        if (bytes == null || bytes.length != 16) {
            return null;
        }
        return UUIDBinarySerializer.bytesToUuid(bytes);
    }

}