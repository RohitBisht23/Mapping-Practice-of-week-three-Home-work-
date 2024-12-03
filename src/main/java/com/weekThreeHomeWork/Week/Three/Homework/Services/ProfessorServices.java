package com.weekThreeHomeWork.Week.Three.Homework.Services;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.ProfessorRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServices {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public ProfessorServices(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    public ProfessorEntity getCreateNewProfessor(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    public ProfessorEntity findProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public List<ProfessorEntity> getAllProfessors() {
        return  professorRepository.findAll();
    }

    public ProfessorEntity assignStudentToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professor = professorRepository.findById(professorId);
        Optional<StudentEntity> student = studentRepository.findById(studentId);

        return professor.flatMap(professor1 ->
                  student.map(student1 -> {
                      professor1.getStudents().add(student1);
                      return professorRepository.save(professor1);
                  })
        ).orElse(null);
    }
}
