package com.example.Librarymanagement.system.controller;

import com.example.Librarymanagement.system.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagement.system.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Librarymanagement.system.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Librarymanagement.system.entity.Student;
import com.example.Librarymanagement.system.exceptions.StudentNotFoundException;
import com.example.Librarymanagement.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

     @Autowired
     StudentService studentService;

     @PostMapping("/addStudent")
     public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
             return studentService.addStudent(studentRequestDto);
     }

     @PutMapping("/updateMobile")
     public UpdateStudentMobileResponseDto updateMobile(@RequestBody UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {
          return studentService.updateMobile(updateStudentMobileRequestDto);
     }


     // delete a student by Id

     // update the student by Id

     // find a student by Id(Use DTO)

     // find all student
}
