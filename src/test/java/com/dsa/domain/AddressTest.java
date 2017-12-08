package com.dsa.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressTest {
    @Test
    public void toStringMethodShouldReturnAllTheAttributesWithoutId() throws Exception {
        Address address = Address.builder()
                .line1("91#123 Serangoon Avenue 1")
                .line1("Block 456")
                .city("Serangoon")
                .line1("central")
                .country("Singapore")
                .zip("550678")
                .build();
        System.out.println(address.toString());
        assertTrue(address.getId() == null);
    }
}