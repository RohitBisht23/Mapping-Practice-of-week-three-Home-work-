package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.AdmissionRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final AdmissionRepository admissionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO endrollNewStudent(StudentDTO studentDTO) {
        // Convert DTOs to Entities
        StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
        // Save the StudentEntity, which will also save the AdmissionEntity due to Cascade
        StudentEntity savedEntity = studentRepository.save(studentEntity);

        // Return the saved StudentEntity as a DTO
        return modelMapper.map(savedEntity, StudentDTO.class);
    }




    @Override
    public StudentDTO getStudentById(Long id) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new ResourceNotFoundException("the professor not found with id "+id);
        }

        return modelMapper.map(entity, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new ResourceNotFoundException("the student not found with id "+id);
        }

        studentRepository.deleteById(id);
        return;
    }
}
