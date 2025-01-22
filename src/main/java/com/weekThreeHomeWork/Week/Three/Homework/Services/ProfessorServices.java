package com.weekThreeHomeWork.Week.Three.Homework.Services;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.SubjectDTO;


import java.util.List;

public interface ProfessorServices {

    List<ProfessorDTO> getAllProfessor();

    ProfessorDTO createProfessor(ProfessorDTO newProfessor);

    ProfessorDTO getProfessorById(Long id);

    void deleteProfessorById(Long id);

    List<SubjectDTO> fetchAllAssignedSubjects(Long id);
}
