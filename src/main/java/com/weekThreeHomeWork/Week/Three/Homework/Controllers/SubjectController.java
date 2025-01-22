package com.weekThreeHomeWork.Week.Three.Homework.Controllers;

import com.weekThreeHomeWork.Week.Three.Homework.Advice.ApiResponse;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.SubjectDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Services.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path="/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/getSubjectById/{id}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long id) {
        return new ResponseEntity<>(subjectService.getSubjectById(id), HttpStatus.OK);
    }

    @PostMapping("/createSubject")
    public ResponseEntity<SubjectDTO> createNewSubject(@RequestBody @Valid SubjectDTO newProject) {
        return new ResponseEntity<>(subjectService.createNewSubject(newProject), HttpStatus.CREATED);
    }

    @PutMapping("/updateSubjectById/{subjectId}")
    public ResponseEntity<SubjectDTO> updateSubjectDetails(@RequestBody SubjectDTO updation, @PathVariable Long subjectId) {
        return new ResponseEntity<>(subjectService.updateSubjectById(subjectId, updation), HttpStatus.OK);
    }

    @DeleteMapping("/deleteSubjectById/{subjectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long subjectId) {
        String response = subjectService.deleteSubjectById(subjectId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/fetchAllSubject")
    public ResponseEntity<List<SubjectDTO>> fetchAllSubjects() {
        return new ResponseEntity<>(subjectService.fetchAllSubjects(), HttpStatus.OK);
    }

    @PutMapping("/{professorId}/assignToSubjectWithId/{subjectId}")
    public ResponseEntity<SubjectDTO> assignProfessorToSubject(@PathVariable Long professorId, @PathVariable Long subjectId) {
        return new ResponseEntity<>(subjectService.assignSubjectToProfessor(professorId, subjectId), HttpStatus.OK);
    }

}
