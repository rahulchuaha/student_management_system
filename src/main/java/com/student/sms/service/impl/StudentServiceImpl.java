package com.student.sms.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.student.sms.dto.StudentDto;
import com.student.sms.entity.Student;
import com.student.sms.mapper.StudentMapper;
import com.student.sms.repository.StudentRepository;
import com.student.sms.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudent() {
    
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                                    .map((student) -> StudentMapper.mapToStudentDto(student))
                                    .collect(Collectors.toList());
                                    return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentdDto) {
     Student student = StudentMapper.maptoStudent(studentdDto);
     studentRepository.save(student);
     
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.maptoStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    
    
}
