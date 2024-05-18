package com.example.ward.Exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String msg){
        super(msg);
    }

    public OrderNotFoundException() {
    }
}
