package com.example.Librarymanagement.system.service;

import com.example.Librarymanagement.system.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagement.system.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Librarymanagement.system.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Librarymanagement.system.entity.Student;
import com.example.Librarymanagement.system.exceptions.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);

    public UpdateStudentMobileResponseDto updateMobile(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException;
}
