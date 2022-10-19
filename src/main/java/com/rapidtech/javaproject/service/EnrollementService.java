package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.*;

import java.util.List;

public interface EnrollementService {
    List<EnrollmentResDTO> getAllEnrollment();
    EnrollmentReqDTO getEnrollmentById(Long id);
    EnrollmentResDTO insertEnrollment(EnrollmentReqDTO enrollmentReqDto);
    EnrollmentResDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto);
    void deleteEnrollment(Long id);
}
