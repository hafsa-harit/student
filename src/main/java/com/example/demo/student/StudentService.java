package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        Optional <Student> studentOptional=studentRespository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("email is taken");
        }
        studentRespository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Boolean exits=studentRespository.existsById(studentId);
        if (!exits)
            throw new IllegalStateException("student id = "+studentId+" does not exist");
        studentRespository.deleteById(studentId);
    }
    //using this annotation means that we won't use any of the Jpa queries 
    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Optional <Student> student=studentRespository.findById(studentID);
        Optional <Student> studentOptional=studentRespository.findStudentByEmail(email);

        if (student == null )
            throw new IllegalStateException("student id = "+studentID+" does not exist");

        //student is type optional student so to get access to student methods we need to use the optional method : optionalStudent.get()
        if (name!=null && name.length()>0 && !Objects.equals(name, student.get().getName()))
            student.get().setName(name);


        if (email!=null && email.length()>0 && !Objects.equals(email, student.get().getEmail()) ) {
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email is taken");
            }
            student.get().setEmail(email);
        }
    }
}
