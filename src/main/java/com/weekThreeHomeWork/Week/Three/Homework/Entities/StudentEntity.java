package com.weekThreeHomeWork.Week.Three.Homework.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    @ManyToMany(mappedBy = "students")
//    @JsonBackReference
//    private List<ProfessorEntity> professors;

    // Use OneToOne with the 'mappedBy' attribute to avoid the creation of another join column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Admission_Column")
    private AdmissionEntity admissionRecord;

}