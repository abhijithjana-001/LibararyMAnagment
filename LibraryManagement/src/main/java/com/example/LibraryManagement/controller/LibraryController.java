package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.dto.requestdto.JwtRequest;
import com.example.LibraryManagement.dto.requestdto.Requestdto;
import com.example.LibraryManagement.dto.responsedto.JwtResponse;
import com.example.LibraryManagement.dto.responsedto.Responsedto;
import com.example.LibraryManagement.entity.Library;
//import com.example.LibraryManagement.security.jwt.JwtAuthFilter;
//import com.example.LibraryManagement.security.jwt.JwtService;
import com.example.LibraryManagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
//    @Autowired
//    private AuthenticationManager manager;
//    @Autowired
//    private UserDetailsService userDetailsService;


//    @Autowired
//    private JwtService jwtService;
    @GetMapping("/test")
    public String test(){

        return "ok";
    }

//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody @Validated JwtRequest requestdto ){
//       this.doAuthenticate(requestdto.getEmail(), requestdto.getPassword());
//        UserDetails userDetails=userDetailsService.loadUserByUsername(requestdto.getEmail());
//        String token=this.jwtService.genaratetoken(userDetails);
//        JwtResponse jwtResponse= JwtResponse.builder().jwtToken(token).username(requestdto.getEmail()).build();
//        return new ResponseEntity(jwtResponse, HttpStatus.OK);
//    }
//
//    private void doAuthenticate(String email,String password){
//        UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(email,password);
//    try{
//        manager.authenticate(auth);
//    }
//    catch (BadCredentialsException e){
//           throw new BadCredentialsException("Invalid user bame and password");
//    }
//    }

    @PostMapping("/addbook")
    public ResponseEntity<Responsedto<Library>> addBook(@RequestBody @Validated Requestdto requestdto ){
        Responsedto<Library> libraryResponsedto = libraryService.addBook(requestdto);
        return ResponseEntity.ok(libraryResponsedto);
    }
    @GetMapping("/list")
    public ResponseEntity<Responsedto<List<Library>>> Books(){
        Responsedto<List<Library>> libraryResponsedto = libraryService.showAll();
        return ResponseEntity.ok(libraryResponsedto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Responsedto<Library>> updateBook(@RequestBody @Validated Requestdto requestdto , @PathVariable long id){
        Responsedto<Library> libraryResponsedto = libraryService.UpdateBook(requestdto,id);
        return ResponseEntity.ok(libraryResponsedto);
    }


    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<Responsedto<Library>> deleteBook(@PathVariable long id){
        Responsedto<Library> libraryResponsedto = libraryService.deleteBook(id);
        return ResponseEntity.ok(libraryResponsedto);
    }
    
}
