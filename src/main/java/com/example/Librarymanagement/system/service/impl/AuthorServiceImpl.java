package com.example.Librarymanagement.system.service.impl;

import aj.org.objectweb.asm.ConstantDynamic;
import com.example.Librarymanagement.system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagement.system.entity.Author;
import com.example.Librarymanagement.system.repository.AuthorRepository;
import com.example.Librarymanagement.system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "Author added successfully";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {

        Author author = authorRepository.findByEmail(email);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setName(author.getName());

        return authorResponseDto;
    }
}
