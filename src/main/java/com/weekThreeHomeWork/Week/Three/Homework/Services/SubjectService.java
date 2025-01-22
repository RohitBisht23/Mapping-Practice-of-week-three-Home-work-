package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.SubjectDTO;

import java.util.List;

public interface SubjectService {

    SubjectDTO getSubjectById(Long id);

    SubjectDTO createNewSubject(SubjectDTO newSubject);

    SubjectDTO updateSubjectById(Long SubjectId, SubjectDTO updation);

    String deleteSubjectById(Long subjectId);

    List<SubjectDTO> fetchAllSubjects();

    SubjectDTO assignSubjectToProfessor(Long professorId, Long subjectId);
}
