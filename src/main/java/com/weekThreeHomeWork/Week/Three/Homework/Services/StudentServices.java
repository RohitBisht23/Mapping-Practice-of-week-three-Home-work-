package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;

import java.util.List;


public interface StudentServices {

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(Long studentId);

    StudentEntity createNewStudent(StudentEntity newStudent);
}
