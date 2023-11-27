package com.example.LibraryManagement.dto.responsedto;

public class ErrorResponse {
    private int statuscode;
    private String message;
    public ErrorResponse(String msg){
        super();
        this.message=msg;
    }
}
