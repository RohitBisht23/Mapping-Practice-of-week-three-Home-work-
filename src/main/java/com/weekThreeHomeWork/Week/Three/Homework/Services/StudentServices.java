package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final StudentRepository studentRepository;


    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity newStudent) {
        return studentRepository.save(newStudent);
    }
}
