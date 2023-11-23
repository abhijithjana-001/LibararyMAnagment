package com.example.LibraryManagement.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Responsedto<T> {
    private  Boolean success;
    private  String message;
    private  T result;
}
