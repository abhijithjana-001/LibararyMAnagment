package com.example.LibraryManagement.dto.requestdto;

import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String password;
}
