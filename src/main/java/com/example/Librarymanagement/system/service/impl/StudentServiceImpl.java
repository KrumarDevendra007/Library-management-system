package com.example.Librarymanagement.system.service.impl;

import com.example.Librarymanagement.system.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagement.system.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Librarymanagement.system.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Librarymanagement.system.entity.Card;
import com.example.Librarymanagement.system.entity.Student;
import com.example.Librarymanagement.system.enums.CardStatus;
import com.example.Librarymanagement.system.exceptions.StudentNotFoundException;
import com.example.Librarymanagement.system.repository.StudentRepository;
import com.example.Librarymanagement.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());



        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-12-31");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student added successfully";
    }

    @Override
    public UpdateStudentMobileResponseDto updateMobile(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {

        try {
            Student student = studentRepository.findById(updateStudentMobileRequestDto.getId()).get();
            student.setMobNo(updateStudentMobileRequestDto.getMobNo());
            Student updateStudent = studentRepository.save(student);

            UpdateStudentMobileResponseDto updateStudentMobileResponseDto = new UpdateStudentMobileResponseDto();
            updateStudentMobileResponseDto.setName(updateStudent.getName());
            updateStudentMobileResponseDto.setMobNo(updateStudentMobileRequestDto.getMobNo());

            return updateStudentMobileResponseDto;

        }
        catch (Exception e){
                throw new StudentNotFoundException("Invalid student id");
        }
    }
}
