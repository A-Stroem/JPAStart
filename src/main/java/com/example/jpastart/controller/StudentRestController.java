package com.example.jpastart.controller;


import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> lst = studentRepository.findAll();
        return lst;
    }

    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        std1.setName("Autogenerated size= " + lst.size());
        studentRepository.save(std1);
        System.out.println("Student save =" + std1.getName());
        return lst;

    }

}
