package com.example.jpastart.config;


import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartAndSave implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {

        Student s1 = new Student();
        s1.setBorn(LocalDate.now());
        s1.setName("Bob");
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setBorn(LocalDate.now().plusDays(3000));
        s2.setName("Pete");
        studentRepository.save(s2);
    }
}
