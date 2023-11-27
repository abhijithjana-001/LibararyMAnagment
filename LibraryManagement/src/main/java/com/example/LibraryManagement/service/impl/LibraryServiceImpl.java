package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.Exception.ItemNotFound;
import com.example.LibraryManagement.dto.requestdto.Requestdto;
import com.example.LibraryManagement.dto.responsedto.Responsedto;
import com.example.LibraryManagement.entity.Library;
import com.example.LibraryManagement.repository.LibraryRepository;
import com.example.LibraryManagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libraryRepository;
    @Override
    public Responsedto<Library> addBook(Requestdto requestdto) {
        Library library=new Library();
        library.setAuthername(requestdto.getAuthername());
        library.setBookname(requestdto.getBookname());
        library.setLibraryname(requestdto.getLibraryname());
        library.setEmail(requestdto.getEmail());
        libraryRepository.save(library);
        return new Responsedto<>(true,"Book added successful",library);
    }

    @Override
    public Responsedto<List<Library>> showAll() {
        List<Library> libraries = libraryRepository.findAll();
        return new Responsedto<>(true,libraries.size()+" books",libraries);
    }

    @Override
    public Responsedto<Library> UpdateBook(Requestdto requestdto, Long id) {
      Library library=  libraryRepository.findById(id).orElseThrow(()->new ItemNotFound("Student not found"));
      if(library!=null){
          library.setLibraryname(requestdto.getLibraryname());
          library.setBookname(requestdto.getBookname());
          library.setAuthername(requestdto.getAuthername());
          library.setEmail(requestdto.getEmail());
          libraryRepository.save(library);
          return new Responsedto<>(true,"updated successful",library);
      }
      else
          return new Responsedto<>(false,"updated unsuccessful",library);
    }

    @Override
    public Responsedto<Library> deleteBook(Long id) {
        libraryRepository.deleteById(id);
        return new Responsedto<>(true,"Deleted successful",null);
    }
}
