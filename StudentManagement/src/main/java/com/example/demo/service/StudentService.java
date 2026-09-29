package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int regno) {
        return repository.findById(regno).orElse(null);
    }

    public void updateStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudent(int regno) {
        repository.deleteById(regno);
    }
}



