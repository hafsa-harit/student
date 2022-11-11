package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")// for navigate to " localhost:8072/api/v1/student "
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }




    @GetMapping
    public List<Student> getStudent(){
        return  studentService.getStudent();
    }
    //it's an implementation of the post method, which will use the json object sent on the request body as
    //a parameter to add it using the addStudent method
    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
