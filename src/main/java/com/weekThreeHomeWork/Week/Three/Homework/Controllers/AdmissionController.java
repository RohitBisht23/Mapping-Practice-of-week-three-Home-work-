package com.weekThreeHomeWork.Week.Three.Homework.Controllers;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Services.AdmissionServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admissionRecords")
public class AdmissionController {

    private final AdmissionServices admissionServices;

    @GetMapping("/GetAllEndrolledStudentsAdmissionDetails")
    public ResponseEntity<List<AdmissionDTO>>  GetAllEndrolledStudents() {
        return new ResponseEntity<>(admissionServices.getAllendrolledStudents(), HttpStatus.OK);
    }

    @PostMapping(path="/endrollNewStudent")
    public ResponseEntity<AdmissionDTO> endrollNewStudent(@RequestBody @Valid AdmissionDTO newStudentRecord) {
        return new ResponseEntity<>(admissionServices.endrollNewStudent(newStudentRecord), HttpStatus.CREATED);
    }

    @GetMapping("/getStudentRecordById/{id}")
    public ResponseEntity<AdmissionDTO> getStudentEndrollementById(@PathVariable Long id) {
        return new ResponseEntity<>(admissionServices.getStudentEndrollementById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudentRecord/{id}")
    public ResponseEntity<String> deleteStudentAdmissionRecord(@PathVariable Long id) {
        admissionServices.deleteStudentAdmissionDetails(id);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/getAdmissionRecordByStudentId/{studentId}")
    public ResponseEntity<AdmissionDTO> getAdmissionRecordById(@PathVariable Long studentId) {
        return new ResponseEntity<>(admissionServices.getAdmissionRecordById(studentId), HttpStatus.OK);
    }
}
