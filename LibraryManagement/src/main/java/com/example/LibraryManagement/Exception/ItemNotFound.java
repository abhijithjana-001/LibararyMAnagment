package com.example.LibraryManagement.Exception;

public class ItemNotFound extends RuntimeException {
   private String message;


    public ItemNotFound(String msg){
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
