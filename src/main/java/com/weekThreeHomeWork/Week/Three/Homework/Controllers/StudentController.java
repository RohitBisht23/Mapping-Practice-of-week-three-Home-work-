package com.weekThreeHomeWork.Week.Three.Homework.Controllers;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="student")
public class StudentController {

    private final StudentServices studentServices;

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentServices.getAllStudents();
    }

    @GetMapping(path="/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId) {
        return studentServices.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity newStudent) {
        return studentServices.createNewStudent(newStudent);
    }
}