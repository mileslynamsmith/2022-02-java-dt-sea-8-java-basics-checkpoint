package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public class Certificate implements IExpireable {

    // Date to when this certificate is valid
    private LocalDate validTo;
    // Subject of the certificate and issuer of the certificate
    private String subject, issuer;

    public Certificate(String subject, String issuer, LocalDate validTo) {
        this.subject = subject;
        this.issuer = issuer;
        this.validTo = validTo;
    }

    public Certificate(String subject, String issuer, long validityPeriodInDays) {
        this.subject = subject;
        this.issuer = issuer;
        this.validTo = LocalDate.now().plusDays(validityPeriodInDays);
    }

    public void renew(long daysValidFromNow) {
        // TODO: renew certificate 
        // set attribute validto to appropriate local date
        this.validTo = LocalDate.now().plusDays(daysValidFromNow);

    }

    @Override
    public boolean isExpired() {
        // TODO: Provide the neccessary check here
        // if the certificate validTo is more than local data than return out of date
        boolean isOutOfDate = LocalDate.now().isAfter(this.validTo);
        return isOutOfDate;
    }

    @Override
    public LocalDate expiryDate() {
        // TODO: Return the expiration date
        // For certificates the date provided is the expiration date 
        //get expiration date & make it a date
        return this.validTo;
    }

    @Override
    public String toString() {
        return String.format("Certificate [Subject: \"%s\", Issuer: \"%s\", Valid Until: \"%s\"]", subject, issuer, validTo.toString());
    }
    
}
