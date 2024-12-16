package com.weekThreeHomeWork.Week.Three.Homework.Controllers;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="student")
public class StudentController {

    private final StudentServices studentServices;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {

        List<StudentDTO> students = (List<StudentDTO>) studentServices.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping(path="/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId) {
        StudentDTO student =   studentServices.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentEntity newStudent) {
        StudentDTO createdStudent = studentServices.createNewStudent(newStudent);
        return ResponseEntity.ok(createdStudent);
    }

    @PostMapping("/{studentId}/assignProfessorToStudent/{professorId}")
    public ResponseEntity<StudentDTO> getAssignProfessorToStudent(@PathVariable Long studentId, @PathVariable Long professorId) {
        StudentDTO studentDTO = studentServices.assignProfessorToStudent(studentId, professorId);
        return ResponseEntity.ok(studentDTO);
    }

}