package com.weekThreeHomeWork.Week.Three.Homework.Controllers;


import com.weekThreeHomeWork.Week.Three.Homework.DTO.ProfessorDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Services.ProfessorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorServices professorServices;

   @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
       List<ProfessorDTO> dtos = (List<ProfessorDTO>) professorServices.getAllProfessors();

       return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Long id) {
        ProfessorDTO professorDTO = professorServices.findProfessorById(id);
        return new ResponseEntity<>(professorDTO, HttpStatus.NOT_FOUND);
    }

   @PostMapping("/createNewProfessor")
    public ResponseEntity<ProfessorDTO> createNewProfessor(@RequestBody ProfessorDTO professorDTO) {
       return ResponseEntity.ok(professorServices.getCreateNewProfessor(professorDTO));
    }

    @PostMapping("/{professorId}/asignStudentToProfessor/{studentId}")
    public ResponseEntity<ProfessorDTO> assignProfessorToDepartment(@PathVariable Long professorId, @PathVariable Long studentId) {
       ProfessorDTO assigedProfessor = professorServices.assignProfessorToStudent(professorId, studentId);

       return new ResponseEntity<>(assigedProfessor, HttpStatus.NOT_FOUND);
    }
}