package com.weekThreeHomeWork.Week.Three.Homework.Services;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;


import java.util.List;

public interface ProfessorServices {

    List<ProfessorDTO> getAllProfessor();

    ProfessorDTO createProfessor(ProfessorDTO newProfessor);

    ProfessorDTO getProfessorById(Long id);

    void deleteProfessorById(Long id);
}
