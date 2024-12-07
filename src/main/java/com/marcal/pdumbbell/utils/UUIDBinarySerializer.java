package com.marcal.pdumbbell.utils;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDBinarySerializer {

    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        return buffer.array();
    }

    public static UUID bytesToUuid(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        long msb = buffer.getLong();
        long lsb = buffer.getLong();
        return new UUID(msb, lsb);
    }

    public static byte[] orderedUuid(byte[] uuidBytes) {
        if (uuidBytes.length != 16) {
            throw new IllegalArgumentException("The byte array must be 16 bytes.");
        }

        byte[] result = new byte[16];

        System.arraycopy(uuidBytes, 0, result, 4, 9);    // Bytes 0 a 8
        System.arraycopy(uuidBytes, 9, result, 2, 2);   // Bytes 9 e 10
        System.arraycopy(uuidBytes, 11, result, 13, 1);  // Byte 11
        System.arraycopy(uuidBytes, 12, result, 14, 2);  // Bytes 12 a 13
        System.arraycopy(uuidBytes, 14, result, 0, 2);  // Bytes 15 e 16
        return result;
    }

    public static byte[] unOrderedUuid(byte[] orderedUuidBytes) {
        if (orderedUuidBytes.length != 16) {
            throw new IllegalArgumentException("The byte array must be 16 bytes.");
        }

        byte[] result = new byte[16];

        System.arraycopy(orderedUuidBytes, 2, result, 9, 2);  // Bytes 10 e 11
        System.arraycopy(orderedUuidBytes, 4, result, 0, 9);   // Bytes 1 a 8
        System.arraycopy(orderedUuidBytes, 0, result, 14, 2); // Bytes 15 e 16
        System.arraycopy(orderedUuidBytes, 14, result, 12, 2); // Bytes 13 a 16
        System.arraycopy(orderedUuidBytes, 13, result, 11, 1); // Bytes 13 a 16

        return result;
    }

}
