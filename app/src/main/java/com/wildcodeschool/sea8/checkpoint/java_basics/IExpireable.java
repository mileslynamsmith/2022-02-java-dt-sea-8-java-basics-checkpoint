package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public interface IExpireable {
    public boolean isExpired();
    public LocalDate expiryDate();
}
