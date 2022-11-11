package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class StudentService {
    private final StudentRespository studentRespository;
    @Autowired
    public StudentService(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    public List<Student> getStudent(){
        //without need to implement nothing from the methodes of the StudentRespository interface we can use them because
        //of the JPARespository :
        return studentRespository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
