package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.StudentEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.AdmissionRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.StudentRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.AdmissionServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionServices {

    private final AdmissionRepository repository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;


    @Override
    public List<AdmissionDTO> getAllendrolledStudents() {
        log.info("Fetching all admission records");
        return repository.findAll()
                .stream()
                .map(admissionEntity -> modelMapper.map(admissionEntity, AdmissionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdmissionDTO endrollNewStudent(AdmissionDTO newStudentRecord) {
        log.info("New Student enrollment");
        AdmissionEntity newAdmissionRecord = modelMapper.map(newStudentRecord, AdmissionEntity.class);

        log.info("Storing new Student Enrollment");
        AdmissionEntity savedStudentRecord = repository.save(newAdmissionRecord);

        log.info("Successfully able to store the new enrollment");
        log.info("Returning back stored enrollment");
        return modelMapper.map(savedStudentRecord, AdmissionDTO.class);
    }

    @Override
    public AdmissionDTO getStudentEndrollementById(Long id) {
        log.info("Fetching student record by id{}", id);

        AdmissionEntity studentRecord = repository.findById(id).orElse(null);
        if(studentRecord ==null) {
            log.error("Get an error while fetching the student record");
            throw new ResourceNotFoundException("No record found with id :"+id);
        }
        log.info("Successfully found the record by id {}, returning the data", id);
        return modelMapper.map(studentRecord, AdmissionDTO.class);
    }

    @Override
    public void deleteStudentAdmissionDetails(Long id) {
        log.info("Fetching the student record by id{}", id);

        AdmissionEntity studentRecord = repository.findById(id).orElse(null);
        if(studentRecord ==null) {
            log.error("Get an error during fetching the student record");
            throw new ResourceNotFoundException("No record found with id :"+id);
        }
        repository.deleteById(id);
        return;
    }

    @Override
    public AdmissionDTO getAdmissionRecordById(Long studentId) {
        log.info("Fetching student's record by id : {}",studentId);

        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow( () -> {
                            log.info("Fetching the student record from database");
                    return new ResourceNotFoundException("Student with give student id not found ");
                });


        log.info("Student successfully found ");
        return modelMapper.map(student.getAdmissionRecord(), AdmissionDTO.class);
    }
}
