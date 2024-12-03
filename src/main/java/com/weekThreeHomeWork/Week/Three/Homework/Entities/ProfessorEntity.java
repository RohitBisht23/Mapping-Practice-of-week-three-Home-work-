package com.weekThreeHomeWork.Week.Three.Homework.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany
    @JoinTable(name="Class_entity_of_professor_and_student",
            joinColumns = @JoinColumn(name = "Professor_id"),
            inverseJoinColumns = @JoinColumn(name = "Student_id")
    )
    private List<StudentEntity> students;
}
