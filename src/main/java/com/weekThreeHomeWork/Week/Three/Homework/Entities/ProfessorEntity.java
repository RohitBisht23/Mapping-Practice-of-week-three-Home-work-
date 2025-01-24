package com.weekThreeHomeWork.Week.Three.Homework.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToMany
//    @JoinTable(name="Class_entity_of_professor_and_student",
//            joinColumns = @JoinColumn(name = "Professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "Student_id")
//    )
//    private List<StudentEntity> students;

    @OneToMany(mappedBy = "professor")
    private List<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "professors")
    private Set<StudentEntity> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
