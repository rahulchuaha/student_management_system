package com.student.sms.service;

import java.util.List;

import com.student.sms.dto.StudentDto;
import com.student.sms.entity.Student;

import jakarta.validation.Valid;

public interface StudentService {

    List<StudentDto> getAllStudent();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long studentId);
    
}
