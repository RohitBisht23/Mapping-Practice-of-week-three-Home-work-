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
    public ResponseEntity<List<StudentDTO>> getAllstudents() {
        return new ResponseEntity<>(studentServices.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping("/enrollNewStudent/studentAdmissionRecords")
    public ResponseEntity<StudentDTO> endrollAllStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentServices.endrollNewStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentServices.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentServices.deleteStudentById(id);  // Service method deletes the student

        // Return a success message as String
        String response = "Student is Deleted Successfully";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getStudentDetailsByAdmissionRecord/{admissionId}")
    public ResponseEntity<StudentDTO> getStudentDetailsByAdmissionRecord(@PathVariable Long admissionId) {
        return new ResponseEntity<>(studentServices.getStudentDetailsByAdmissionId(admissionId), HttpStatus.OK);
    }

}