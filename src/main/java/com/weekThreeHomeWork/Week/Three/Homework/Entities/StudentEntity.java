package com.weekThreeHomeWork.Week.Three.Homework.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // Use OneToOne with the 'mappedBy' attribute to avoid the creation of another join column
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Admission_Column")
    private AdmissionEntity admissionRecord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "professor_student",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "professors_id")
    )
    private Set<ProfessorEntity> professors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity student)) return false;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}