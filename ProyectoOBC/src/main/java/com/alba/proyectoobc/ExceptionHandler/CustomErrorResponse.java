package com.alba.proyectoobc.ExceptionHandler;

import lombok.Data;

@Data
public class CustomErrorResponse extends RuntimeException{

    private String ex_message;

    public CustomErrorResponse(Class cla, String message, String ex_message){

        super("Class name: " + cla.getSimpleName() + ", " + message);
        this.ex_message = ex_message;
    }
}
