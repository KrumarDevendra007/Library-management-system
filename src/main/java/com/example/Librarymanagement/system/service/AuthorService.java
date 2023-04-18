package com.example.Librarymanagement.system.service;

import com.example.Librarymanagement.system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagement.system.entity.Author;

public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getAuthorByEmail(String email);
}
