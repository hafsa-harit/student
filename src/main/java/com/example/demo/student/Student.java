package com.example.demo.student;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//we need to give the database a name and password so we can execute the persistance on postgresql
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    //this attribute will be calculated and not stored in our database :
    @Transient
    private Integer age;


    //constructeurs:

    public Student() {

    }

    public Student(long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name,
                   String email,
                   LocalDate dob
    ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

// getters and setters:

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {

        return Period.between(this.dob , LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
