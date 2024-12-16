package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.StudentServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private  final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        StudentEntity findStudent = studentRepository
                .findById(studentId).orElseThrow(()-> new ResourceNotFoundException("The student is not found with id "+studentId));

        return modelMapper.map(findStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO createNewStudent(StudentEntity newStudent) {
        StudentEntity savingStudent = modelMapper.map(newStudent, StudentEntity.class);

        StudentEntity savedStudent = studentRepository.save(savingStudent);

        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<StudentEntity> studentEntityOpt = studentRepository.findById(studentId);
        Optional<ProfessorEntity> professorEntityOpt = professorRepository.findById(professorId);

        if (studentEntityOpt.isPresent() && professorEntityOpt.isPresent()) {
            StudentEntity student = studentEntityOpt.get();
            ProfessorEntity professor = professorEntityOpt.get();

            // Synchronize both sides of the relationship
            professor.getStudents().add(student);
            student.getProfessors().add(professor);

            // Save entities
            professorRepository.save(professor);
            studentRepository.save(student);

            // Return StudentDTO with professor details included
            return modelMapper.map(student, StudentDTO.class);
        }

        throw new EntityNotFoundException("Professor or Student not found");
    }

}
