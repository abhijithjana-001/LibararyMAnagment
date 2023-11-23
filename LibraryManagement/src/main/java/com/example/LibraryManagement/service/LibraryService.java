package com.example.LibraryManagement.service;

import com.example.LibraryManagement.dto.requestdto.Requestdto;
import com.example.LibraryManagement.dto.responsedto.Responsedto;
import com.example.LibraryManagement.entity.Library;

import java.util.List;

public interface LibraryService {
  public Responsedto<Library> addBook(Requestdto requestdto);
    public Responsedto<List<Library>> showAll();

    public Responsedto<Library> UpdateBook(Requestdto requestdto,Long id);

    public Responsedto<Library> deleteBook(Long id);



}
