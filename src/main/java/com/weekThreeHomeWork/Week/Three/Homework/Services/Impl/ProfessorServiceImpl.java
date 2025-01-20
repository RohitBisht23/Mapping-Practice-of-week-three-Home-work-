package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
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
    private final ModelMapper modelMapper;

    @Override
    public List<ProfessorDTO> getAllProfessor() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> modelMapper.map(professor, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO newProfessor) {
        ProfessorEntity entity = modelMapper.map(newProfessor, ProfessorEntity.class);
        ProfessorEntity savedProfessor = professorRepository.save(entity);

        return modelMapper.map(savedProfessor, ProfessorDTO.class);
    }

    @Override
    public ProfessorDTO getProfessorById(Long id) {
        ProfessorEntity entity = professorRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new ResourceNotFoundException("the professor not found with id "+id);
        }
        return modelMapper.map(entity, ProfessorDTO.class);
    }

    @Override
    public void deleteProfessorById(Long id) {
        ProfessorEntity entity = professorRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new ResourceNotFoundException("the professor not found with id "+id);
        }

        professorRepository.deleteById(id);
    }
}
