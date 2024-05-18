package com.example.ward.Exception;

public class NurseNotFoundException extends RuntimeException{
    public NurseNotFoundException() {
    }

    public NurseNotFoundException(String msg){
        super(msg);
    }
}
