package com.weekThreeHomeWork.Week.Three.Homework.DTO;


import jakarta.validation.Valid;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {

    private Long id;
    private String name;

    @Valid
    private AdmissionDTO admissionRecord;

    private Set<ProfessorDTO> professors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
