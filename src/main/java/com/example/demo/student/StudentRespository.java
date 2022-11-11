package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//responsible for data access :
@Repository
public interface StudentRespository
        extends JpaRepository<Student,Long> {



}
