package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;

import java.util.List;


public interface StudentServices {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long studentId);

    StudentDTO createNewStudent(StudentEntity newStudent);

    StudentDTO assignProfessorToStudent(Long professorId, Long studentId);
}
