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
        // expiry date for dairy products it is the date produced followed by the days it is fresh.
        boolean isOutOfDate = LocalDate.now().plusDays(this.daysUntilSpoiled).isAfter(this.dateProduced);
        return isOutOfDate;
    }

    @Override
    public LocalDate expiryDate() {
        // TODO: Return the expiration date
        LocalDate expirationDate = this.dateProduced.plusDays(this.daysUntilSpoiled);
        return expirationDate;
    }

    @Override
    public String toString() {
        return String.format("DairyProduct [Date Produced: \"%s\", Expiration Date: \"%s\"]", dateProduced, expiryDate());
    }
    
}
