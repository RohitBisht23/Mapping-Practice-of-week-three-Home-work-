package com.weekThreeHomeWork.Week.Three.Homework.Repositories;

import com.weekThreeHomeWork.Week.Three.Homework.Entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    List<SubjectEntity> findByProfessorId(Long id);
}
