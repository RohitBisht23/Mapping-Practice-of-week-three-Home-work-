package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdmissionServices {


    List<AdmissionDTO> getAllendrolledStudents();

    AdmissionDTO endrollNewStudent(AdmissionDTO newStudentRecord);

    AdmissionDTO getStudentEndrollementById(Long id);

    void deleteStudentAdmissionDetails(Long id);

    AdmissionDTO getAdmissionRecordById(Long studentId);
}
