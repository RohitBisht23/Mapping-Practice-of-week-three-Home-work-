package com.weekThreeHomeWork.Week.Three.Homework.Services.Impl;

import com.weekThreeHomeWork.Week.Three.Homework.DTO.AdmissionDTO;
import com.weekThreeHomeWork.Week.Three.Homework.DTO.StudentDTO;
import com.weekThreeHomeWork.Week.Three.Homework.Entities.AdmissionEntity;
import com.weekThreeHomeWork.Week.Three.Homework.Exceptions.ResourceNotFoundException;
import com.weekThreeHomeWork.Week.Three.Homework.Repositories.AdmissionRepository;
import com.weekThreeHomeWork.Week.Three.Homework.Services.AdmissionServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionServices {

    private final AdmissionRepository admissionRepository;
    private final ModelMapper modelMapper;

    @Override
    public AdmissionDTO enrollStudent(AdmissionDTO newStudent) {
        return modelMapper.map(
                admissionRepository.save(
                        modelMapper.map(newStudent, AdmissionEntity.class)
                ),
                AdmissionDTO.class
        );
    }

    @Override
    public List<AdmissionDTO> getAllEnrolledStudent() {
        return  admissionRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, AdmissionDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public AdmissionDTO updateStudentEnrollmentDetails(Long enrolledId, AdmissionDTO admissionRecordDto) {
        return null;
    }

    @Override
    public AdmissionDTO assignStudentToRecord(Long enrolledId, Long studentId) {
        return null;
    }

    @Override
    public AdmissionDTO getStudentEnrollementDetailById(Long id) {
        isExistByIdAdmissionRecord(id);
        return modelMapper.map(admissionRepository.findById(id), AdmissionDTO.class);
    }


    private void isExistByIdAdmissionRecord(Long id){
        boolean isExist=admissionRepository.existsById(id);
        if(!isExist) throw new ResourceNotFoundException("Admission record not found by id:"+id);
    }
}
