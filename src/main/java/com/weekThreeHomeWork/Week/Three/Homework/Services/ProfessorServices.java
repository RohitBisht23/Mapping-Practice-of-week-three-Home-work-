package com.weekThreeHomeWork.Week.Three.Homework.Services;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;


import java.util.List;

public interface ProfessorServices {




    ProfessorDTO getCreateNewProfessor(ProfessorDTO professor);

    ProfessorDTO findProfessorById(Long id);

    public List<ProfessorDTO> getAllProfessors();
}
