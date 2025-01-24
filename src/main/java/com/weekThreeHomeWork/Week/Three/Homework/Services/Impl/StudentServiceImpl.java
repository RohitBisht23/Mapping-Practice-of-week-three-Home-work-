package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.AdmissionRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final AdmissionRepository admissionRepository;
    private final ProfessorRepository professorRepository;
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
    public String deleteStudentById(Long id) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new ResourceNotFoundException("the student not found with id "+id);
        }

        studentRepository.deleteById(id);
        return "Student is deleted successfully";
    }

    @Override
    public StudentDTO getStudentDetailsByAdmissionId(Long admissionId) {
        AdmissionEntity admission = AdmissionEntity.builder().id(admissionId).build(); //Only id field will not be null rest are null
        StudentEntity student = studentRepository.findByAdmissionRecord(admission);

        if (student == null) {
            throw new ResourceNotFoundException("No student found for admission ID: " + admissionId);
        }

        // Convert StudentEntity to StudentDTO
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    @Transactional
    public StudentDTO assignProfessorToStudent(Long professorId, Long studentId) {
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not find with the id :" + studentId));

        ProfessorEntity professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Student not find with the id :" + studentId));


        // Add student to the professor's list of students
        professor.getStudents().add(student);

        // Add professor to the student's list of professors
        student.getProfessors().add(professor);

        // Save both entities to update the database
        professorRepository.save(professor);
        //studentRepository.save(student);
        //StudentEntity savedStudent = studentRepository.save(student);

        StudentDTO returnDTO = modelMapper.map(student, StudentDTO.class);
        return returnDTO;

    }

}