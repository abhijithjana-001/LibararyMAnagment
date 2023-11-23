package com.example.LibraryManagement.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class JwtResponse {
    private String jwtToken;
   private String  username;
}
