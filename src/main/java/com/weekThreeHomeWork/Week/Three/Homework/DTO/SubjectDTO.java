package com.weekThreeHomeWork.Week.Three.Homework.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDTO {

    private Long id;
    private String title;

    @JsonIgnore
    private ProfessorDTO professor;

}
