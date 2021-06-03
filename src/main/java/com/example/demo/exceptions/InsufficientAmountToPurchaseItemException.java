package com.example.demo.exceptions;

public class InsufficientAmountToPurchaseItemException extends RuntimeException {
    private String message;

    public InsufficientAmountToPurchaseItemException(String msg){super(msg);}
}