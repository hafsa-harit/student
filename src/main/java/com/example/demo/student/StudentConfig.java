package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRespository respository) {
        return args -> {
            Student hafse = new Student(
                    "Hafsa",
                    "hafsa@gmail.com",
                    LocalDate.of(2001, 02, 02)
            );
            Student hafsa = new Student(
                    "Hafsa",
                    "hafsa@gmail.com",
                    LocalDate.of(2001, 02, 02)
            );
            respository.saveAll(
                    List.of(hafsa, hafse)
            );

        };
    }
}
