package com.weekThreeHomeWork.Week.Three.Homework.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDTO {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdmission;

    @JsonIgnore
    private StudentDTO student;

}
