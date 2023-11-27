package com.example.LibraryManagement.Exception;

public class BadRequest extends RuntimeException {
   private String message;


    public BadRequest(String msg){
        super(msg);
        this.message=msg;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
