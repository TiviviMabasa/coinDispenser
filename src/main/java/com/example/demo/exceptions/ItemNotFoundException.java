package com.example.demo.exceptions;

public class ItemNotFoundException extends RuntimeException {
    private String message;

    public ItemNotFoundException(String msg){super(msg);}
}