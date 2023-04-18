package com.example.Librarymanagement.system.controller;

import com.example.Librarymanagement.system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagement.system.entity.Author;
import com.example.Librarymanagement.system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @GetMapping("/getByEmail")
    public AuthorResponseDto getByEmail(@RequestParam("email") String email){
          return authorService.getAuthorByEmail(email);
    }

    // Get all the author of particular age
}
