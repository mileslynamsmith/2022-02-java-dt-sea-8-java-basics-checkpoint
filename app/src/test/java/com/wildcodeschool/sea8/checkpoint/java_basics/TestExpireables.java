package com.wildcodeschool.sea8.checkpoint.java_basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TestExpireables {
    @Test
    public void testCertificateExpiration() {
        Certificate testCertificate = new Certificate("SEA 8 Checkpoint", "Wild Code School", LocalDate.now().plusDays(60));
        assertFalse(testCertificate.isExpired(), String.format("%s should be valid for the next 60 days.", testCertificate.toString()));
        assertEquals(LocalDate.now().plusDays(60), testCertificate.expiryDate(), "Expiry date does not match expected date.");

        testCertificate = new Certificate("SEA 8 Checkpoint", "Wild Code School", LocalDate.now().minusDays(60));
        assertTrue(testCertificate.isExpired(), String.format("%s should be expired since 60 days.", testCertificate.toString()));
        assertEquals(LocalDate.now().minusDays(60), testCertificate.expiryDate(), "Expiry date does not match expected date.");

        testCertificate.renew(30);
        assertFalse(testCertificate.isExpired(), String.format("%s should have been renewed for 30 days from now.", testCertificate.toString()));
        assertEquals(LocalDate.now().plusDays(30), testCertificate.expiryDate(), "Expiry date does not match expected date.");
    }

    @Test
    public void testDairyProductExpiration() {
        DairyProduct product = new DairyProduct(14);
        assertFalse(product.isExpired(), String.format("%s should be fresh for 14 days.", product.toString()));
        assertEquals(LocalDate.now().plusDays(14), product.expiryDate(), "Expiry date does not match expected date.");

        product = new DairyProduct(LocalDate.now().minusDays(30), 20);
        assertTrue(product.isExpired(), String.format("%s should be spoiled since 10 days.", product.toString()));
        assertEquals(LocalDate.now().minusDays(10), product.expiryDate(), "Expiry date does not match expected date.");
    }
}
