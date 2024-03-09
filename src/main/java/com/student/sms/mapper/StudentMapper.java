package com.student.sms.mapper;

import com.student.sms.dto.StudentDto;
import com.student.sms.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto(
            student.getId(),
            student.getFirstName(), 
            student.getLastName(),
            student.getEmail()
        );
        return studentDto;
    }

    public static Student maptoStudent(StudentDto studentDto){
        Student student = new Student(
            studentDto.getId(), 
            studentDto.getFirstName(), 
            studentDto.getLastName(), 
            studentDto.getEmail()
            );
            return student;
    }
    
}
