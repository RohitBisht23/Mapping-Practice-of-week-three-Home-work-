package com.weekThreeHomeWork.Week.Three.Homework.Repositories;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
