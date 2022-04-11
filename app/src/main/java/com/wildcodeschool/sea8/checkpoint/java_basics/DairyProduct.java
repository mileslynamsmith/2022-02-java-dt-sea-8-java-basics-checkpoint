package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public class DairyProduct implements IExpireable {
    private LocalDate dateProduced;
    private int daysUntilSpoiled;

    public DairyProduct(int daysUntilSpoiled) {
        this.dateProduced = LocalDate.now();
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    public DairyProduct(LocalDate dateProduced, int daysUntilSpoiled) {
        this.dateProduced = dateProduced;
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    @Override
    public boolean isExpired() {
        // TODO: Provide the neccessary check here
        return false;
    }

    @Override
    public LocalDate expiryDate() {
        // TODO: Return the expiration date
        return null;
    }

    @Override
    public String toString() {
        return String.format("DairyProduct [Date Produced: \"%s\", Expiration Date: \"%s\"]", dateProduced, expiryDate());
    }
    
}
