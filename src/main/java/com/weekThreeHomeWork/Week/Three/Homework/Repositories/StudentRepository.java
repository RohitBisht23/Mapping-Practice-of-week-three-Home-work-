package com.weekThreeHomeWork.Week.Three.Homework.Repositories;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByAdmissionRecord(AdmissionEntity admission);
}
