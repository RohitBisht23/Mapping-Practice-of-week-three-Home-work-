package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentEntity> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentEntity getStudentById(Long studentId) {
        return null;
    }

    @Override
    public StudentEntity createNewStudent(StudentEntity newStudent) {
        return null;
    }
}
