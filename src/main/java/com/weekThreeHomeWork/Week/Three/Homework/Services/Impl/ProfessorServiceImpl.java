package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.ProfessorServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
