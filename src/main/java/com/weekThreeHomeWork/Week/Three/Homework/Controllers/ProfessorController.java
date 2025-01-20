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
    public ResponseEntity<List<ProfessorDTO>> getAllProfessor() {
        return new ResponseEntity<>(professorServices.getAllProfessor(), HttpStatus.OK);
    }

    @PostMapping("/createNewProfessor")
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO newProfessor) {
        return new ResponseEntity<>(professorServices.createProfessor(newProfessor), HttpStatus.CREATED);
    }

    @GetMapping("/getProfessorById/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Long id) {
        return new ResponseEntity<>(professorServices.getProfessorById(id), HttpStatus.OK);
    }

    @DeleteMapping("/DeleteProfessorById")
    public ResponseEntity<String> deleteProfessorById(@PathVariable Long id) {
        professorServices.deleteProfessorById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}