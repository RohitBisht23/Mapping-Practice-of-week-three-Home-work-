package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.SubjectDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.SubjectEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.SubjectRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {


    private final SubjectRepository repository;
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    @Override
    public SubjectDTO getSubjectById(Long id) {
        log.info("Fetching the subject with id :{}",id);
        SubjectEntity project = repository.findById(id).orElse(null);

        if(project == null) {
                log.info("Subject not found with id :{}", id);
                throw new ResourceNotFoundException("Subject not found with id :"+ id);
        }
        log.info("We are successfully able to get the subject from database, returning back");
        return modelMapper.map(project, SubjectDTO.class);
    }

    @Override
    public SubjectDTO createNewSubject(SubjectDTO newProject) {
        log.info("Creating the new subject");

        SubjectEntity newProjectCreating = modelMapper.map(newProject, SubjectEntity.class);

        log.info("Saving the new subject, and returning back");
        SubjectEntity savedSubject = repository.save(newProjectCreating);
        return modelMapper.map(savedSubject, SubjectDTO.class);
    }

    @Override
    public SubjectDTO updateSubjectById(Long subjectId, SubjectDTO updation) {
        return null;
    }

    @Override
    public String deleteSubjectById(Long projectId) {
        log.info("Fetching the Subject with id :{} to delete",projectId);
        SubjectEntity project = repository.findById(projectId).orElse(null);

        if(project == null) {
            log.info("Subject not found with given id :{}", projectId);
            throw new ResourceNotFoundException("Subject not found with id :"+ projectId);
        }
        log.info("Deleting the Subject by give id :{}", projectId);
        repository.deleteById(projectId);
        return "Subject is deleted";
    }

    @Override
    public List<SubjectDTO> fetchAllSubjects() {
        log.info("Fetching all the subjects");
         return repository.findAll().stream().map(projectEntity -> modelMapper.map(projectEntity, SubjectDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SubjectDTO assignSubjectToProfessor(Long professorId, Long subjectId) {
        log.info("Assign the subjects to professor");

        log.info("Fetching the subject to check if exists or not with id :{}", subjectId);
        SubjectEntity subjectEntity = repository.findById(subjectId).orElseThrow(() ->{
            log.info("Subject with give id not found :{}",subjectId);
            return new ResourceNotFoundException("Subject is not listed with given id");
        });

        log.info("Fetching the professor from the databased to check if present or not");
        ProfessorEntity professorEntity = professorRepository.findById(professorId).orElseThrow(() ->{
            log.info("Professor with give id not found :{}",professorId);
            return new ResourceNotFoundException("Professor not found with given id");
        });

        log.info("Assign the subject to the professors and returning back the subject.");
        subjectEntity.setProfessor(professorEntity);
        SubjectEntity savedSubject = repository.save(subjectEntity);
        return modelMapper.map(savedSubject, SubjectDTO.class);

//        Optional<ProfessorEntity> professorEntity= professorRepository.findById(professorId);
//        Optional<SubjectEntity> subjectEntity = repository.findById(subjectId);
//
//        return subjectEntity.flatMap(subjectEntity1 ->
//                professorEntity.map(professor -> {
//                    subjectEntity1.setProfessor(professor);
//                    subjectEntity1.setProfessor(professor);
//                    return modelMapper.map(repository.save(subjectEntity1), SubjectDTO.class);
//                })
//        ).orElse(null);
    }
}
