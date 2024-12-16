package com.weekThreeHomeWork.Week.Three.Homework.Controllers;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Services.AdmissionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdmissionController {

    private final AdmissionServices admissionServices;

    @GetMapping
    public ResponseEntity<AdmissionDTO> getAdmitStudent(@RequestBody AdmissionDTO newStudent) {
        return new ResponseEntity<>(admissionServices.enrollStudent(newStudent), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AdmissionDTO>> getAllEnrolledStudents() {
        return  ResponseEntity.ok(admissionServices.getAllEnrolledStudent());
    }

    @PutMapping("/{enrolledId}")
    public ResponseEntity<AdmissionDTO> updateStudentEnrollmentDetails(@PathVariable Long enrolledId, @ResponseBody AdmissionDTO admissionRecordDto) {
        return new ResponseEntity<>(admissionServices.updateStudentEnrollmentDetails(enrolledId,admissionRecordDto));
    }

    @PutMapping("/{enrolledId}/assignStudent/{studentId}")
    public ResponseEntity<AdmissionDTO> assignStudentToRecord(@PathVariable Long enrolledId,@PathVariable Long studentId){
        return ResponseEntity.ok(admissionServices.assignStudentToRecord(enrolledId,studentId));
    }

    @GetMapping("/studentId/{id}")
    public ResponseEntity<AdmissionDTO> getStudentEnrollementDetailById(@PathVariable Long id) {
         AdmissionDTO studentDetails = admissionServices.getStudentEnrollementDetailById(id);
         return new ResponseEntity<>(studentDetails, HttpStatus.NOT_FOUND);
    }
}
