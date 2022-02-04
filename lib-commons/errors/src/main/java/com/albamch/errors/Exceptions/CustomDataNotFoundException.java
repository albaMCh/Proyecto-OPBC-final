package com.albamch.errors.Exceptions;

public class CustomDataNotFoundException extends RuntimeException{

    public CustomDataNotFoundException (Class cla, String message){
        super(cla.getName() + message);
    }

    public CustomDataNotFoundException(Class cla, String message, Throwable cause){

        super(cla.getName() +  ": "+ message, cause);
    }
}
