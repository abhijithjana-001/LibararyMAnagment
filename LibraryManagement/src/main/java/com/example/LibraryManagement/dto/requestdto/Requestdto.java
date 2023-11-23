package com.example.LibraryManagement.dto.requestdto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
public class Requestdto {
    private String libraryname;

    private String authername;
    private String bookname;
    @Email
    private String email;

}
