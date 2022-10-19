package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.EnrollmentReqDTO;
import com.rapidtech.javaproject.dto.EnrollmentResDTO;
import com.rapidtech.javaproject.dto.StudentReqDTO;
import com.rapidtech.javaproject.dto.StudentResDTO;

import java.util.List;

public interface EnrollementService {
    List<EnrollmentResDTO> getAllEnrollment();
    EnrollmentReqDTO getEnrollmentById(Long id);
    EnrollmentResDTO insertEnrollment(EnrollmentReqDTO enrollmentReqDto);
    EnrollmentResDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto);
    void deleteEnrollment(Long id);
}
