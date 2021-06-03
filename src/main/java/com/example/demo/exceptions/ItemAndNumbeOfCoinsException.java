package com.example.demo.exceptions;

public class ItemAndNumbeOfCoinsException extends RuntimeException {
    private String message;

    public ItemAndNumbeOfCoinsException(String msg){super(msg);}
}

