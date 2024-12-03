package com.weekThreeHomeWork.Week.Three.Homework.Controllers;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Services.ProfessorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="professor")
public class ProfessorController {

    private final ProfessorServices professorServices;

    public ProfessorController(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professor) {
        return professorServices.getCreateNewProfessor(professor);
    }

    @GetMapping(path="/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId) {
        return professorServices.findProfessorById(professorId);
    }

    @GetMapping
    public List<ProfessorEntity> getAllProfessors() {
        return professorServices.getAllProfessors();
    }

    @PostMapping("/assignStudentToProfessors/{professorId}/to/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long professorId, @PathVariable Long studentId) {
        return professorServices.assignStudentToProfessor(professorId, studentId);
    }
}