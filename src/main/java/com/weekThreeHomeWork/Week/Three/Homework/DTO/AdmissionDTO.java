package com.weekThreeHomeWork.Week.Three.Homework.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDTO {

    private Long id;
    private Date dateOfJoin;

    private String studentName;
}
