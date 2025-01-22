package com.weekThreeHomeWork.Week.Three.Homework.DTO;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;

    @Valid
    private AdmissionDTO admissionRecord;
}
