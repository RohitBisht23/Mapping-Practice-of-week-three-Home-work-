package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.ProfessorServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorServices {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    public ProfessorDTO getCreateNewProfessor(ProfessorDTO professor) {
        ProfessorEntity professorEntity = modelMapper.map(professor, ProfessorEntity.class);
        ProfessorEntity savedProfessor = professorRepository.save(professorEntity);

        return modelMapper.map(savedProfessor, ProfessorDTO.class);
    }

    public ProfessorDTO findProfessorById(Long id) {
        return professorRepository.findById(id)
                .map(professor -> modelMapper.map(professor, ProfessorDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Professor with ID " + id + " not found"));
    }


    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> modelMapper.map(professor, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    public ProfessorDTO assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<StudentEntity> studentEntityOpt = studentRepository.findById(studentId);
        Optional<ProfessorEntity> professorEntityOpt = professorRepository.findById(professorId);

        if (studentEntityOpt.isPresent() && professorEntityOpt.isPresent()) {
            StudentEntity student = studentEntityOpt.get();
            ProfessorEntity professor = professorEntityOpt.get();

            // Add the student to the professor's list
            professor.getStudents().add(student);

            // Add the professor to the student's list
            student.getProfessors().add(professor);

            // Save both entities
            professorRepository.save(professor);
            studentRepository.save(student);

            return modelMapper.map(professor, ProfessorDTO.class);
        }

        // Handle case where either entity is not found
        throw new EntityNotFoundException("Professor or Student not found");
    }

}
