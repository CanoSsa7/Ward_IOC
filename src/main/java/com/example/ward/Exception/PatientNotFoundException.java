package com.example.ward.Exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String msg){
        super(msg);
    }

    public PatientNotFoundException() {
    }
}
