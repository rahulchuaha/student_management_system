package com.student.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.sms.dto.StudentDto;
import com.student.sms.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    // handler methode to handle the list of student

    @GetMapping("/students")
    public String studentList(Model model){
        List<StudentDto> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "students";
    }

    // handler methode to handle the new Student

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create-stuedent";
    }

    // handler methode to handle save student

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result,
                                       Model model){

                                        if(result.hasErrors()){
                                            model.addAttribute("student", student);
                                            return "create-stuedent";
                                        }

        studentService.createStudent(student);

        return "redirect:/students";

    }

    //handler methode to handle the edit student

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){

        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit-student";



    }

    // handler methode to handle edit student

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                    @Valid @ModelAttribute("student") StudentDto studentDto,
                                         BindingResult result, Model model){

                                            if(result.hasErrors()){
                                                model.addAttribute("student", studentDto);
                                                return "edit-student";
                                            }
                    studentDto.setId(studentId);
                    studentService.updateStudent(studentDto);
                    return "redirect:/students";
    }

    // handler methode to handle delete student

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    // handler methode to handle the view of student page

    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, 
                       Model model){

                        StudentDto studentDto = studentService.getStudentById(studentId);
                        model.addAttribute("student", studentDto);
                        return "view-student";
                    
                    }
}
