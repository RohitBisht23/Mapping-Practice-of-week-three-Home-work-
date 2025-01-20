package com.weekThreeHomeWork.Week.Three.Homework.Repositories;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<AdmissionEntity, Long> {
}
