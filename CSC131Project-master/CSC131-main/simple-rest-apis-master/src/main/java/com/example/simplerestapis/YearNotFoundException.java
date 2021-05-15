package com.example.simplerestapis;

public class YearNotFoundException extends RuntimeException {
    public YearNotFoundException() {
        super("Year not Found");
    }
}
