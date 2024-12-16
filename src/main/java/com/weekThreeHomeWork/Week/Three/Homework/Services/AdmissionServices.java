package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdmissionServices {

    AdmissionDTO enrollStudent(AdmissionDTO newStudent);

    List<AdmissionDTO> getAllEnrolledStudent();

    AdmissionDTO updateStudentEnrollmentDetails(Long enrolledId, AdmissionDTO admissionRecordDto);

    AdmissionDTO assignStudentToRecord(Long enrolledId, Long studentId);

    AdmissionDTO getStudentEnrollementDetailById(Long id);
}
