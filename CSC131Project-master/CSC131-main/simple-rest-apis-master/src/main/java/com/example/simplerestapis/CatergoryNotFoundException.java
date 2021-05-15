package com.example.simplerestapis;

public class CatergoryNotFoundException extends RuntimeException {
    public CatergoryNotFoundException() {
        super("Category not Found");
    }
}
