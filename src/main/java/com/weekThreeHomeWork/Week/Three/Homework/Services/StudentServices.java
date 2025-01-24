package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;

import java.util.List;


public interface StudentServices {


    List<StudentDTO> getAllStudent();

    StudentDTO endrollNewStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long id);

    String deleteStudentById(Long id);

    StudentDTO getStudentDetailsByAdmissionId(Long admissionId);

    StudentDTO assignProfessorToStudent(Long professorId, Long studentId);
}
