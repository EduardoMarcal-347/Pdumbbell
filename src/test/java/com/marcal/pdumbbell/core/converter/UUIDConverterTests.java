package com.marcal.pdumbbell.core.converter;

import com.marcal.pdumbbell.core.utils.UUIDBinarySerializer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UUIDConverterTests {

    @Test
    public void testOrderedUUIDConversion() {
        UUID originalUUID = UUID.randomUUID();
        byte[] originalUUIDBytes = UUIDBinarySerializer.uuidToBytes(originalUUID);
        byte[] orderedUUIDBytes = UUIDBinarySerializer.orderedUuid(originalUUIDBytes);

        assertEquals(16, orderedUUIDBytes.length, "O tamanho do array deve ser 16 bytes");

        byte[] unorderedUUIDBytes = UUIDBinarySerializer.unOrderedUuid(orderedUUIDBytes);
        assertEquals(Arrays.toString(originalUUIDBytes), Arrays.toString(unorderedUUIDBytes), "O byte[] convertido deve ser igual ao original");

        UUID convertedUUID = UUIDBinarySerializer.bytesToUuid(unorderedUUIDBytes);
        assertEquals(originalUUID, convertedUUID, "O UUID convertido deve ser igual ao original");
    }


}
