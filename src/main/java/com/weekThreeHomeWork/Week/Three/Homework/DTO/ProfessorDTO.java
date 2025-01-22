package com.weekThreeHomeWork.Week.Three.Homework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {

    private Long id;
    private String name;


    List<SubjectDTO> subjects;
}
