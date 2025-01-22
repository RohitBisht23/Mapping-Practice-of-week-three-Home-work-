package com.weekThreeHomeWork.Week.Three.Homework.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weekThreeHomeWork.Week.Three.Homework.Annotation.feesAnnotation;
import jakarta.validation.constraints.PastOrPresent;
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
    @PastOrPresent
    private Date dateOfAdmission;

    @feesAnnotation(message = "You may have entered wrong fees")
    private Integer fees;

    @JsonIgnore
    private StudentDTO student;

}
