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



    //the fact that this controller is a RestController get us the possibility t not
    //define the object retunred from this method by the annotation : @RispenseBody
    @GetMapping
    public List<Student> getStudent(){
        return  studentService.getStudent();
    }


    //it's an implementation of the post method, which will use the json object sent on the request body as
    //a parameter to add it using the addStudent method
    @PostMapping
    public void registerNewStudent (
            @RequestBody Student student){
        studentService.addNewStudent(student);
    }
    //here we will take the parameter studentID from the uri and send it to the studentService so we can
    //use it to find the student we want to delete using studentRispository
    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(
            @PathVariable("studentID") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(
            @RequestParam Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {
        studentService.updateStudent(studentID,name,email);
    }



}
