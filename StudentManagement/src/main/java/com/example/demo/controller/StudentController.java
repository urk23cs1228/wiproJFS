package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        service.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam int regno, Model model) {
        Student student = service.getStudentById(regno);
        model.addAttribute("student", student);
        return "search-result";
    }

    @GetMapping("/edit/{regno}")
    public String editStudent(@PathVariable int regno, Model model) {
        Student student = service.getStudentById(regno);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        service.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{regno}")
    public String deleteStudent(@PathVariable int regno) {
        service.deleteStudent(regno);
        return "redirect:/students";
    }
}



