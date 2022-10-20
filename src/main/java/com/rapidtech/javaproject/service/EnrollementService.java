package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.*;

import java.util.List;

public interface EnrollementService {
    List<EnrollmentResDTO> getAllEnrollment();
    EnrollmentReqDTO getEnrollmentById(Long id);
    EnrollmentResDTO insertEnrollment(EnrollmentReqDTO enrollmentReqDto);
    //EnrollmentResDTO newStudentEnrollment(NewStudentWithCourseReqDTO newStudentWithCourseReqDTO);
    EnrollmentDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto);
    void deleteEnrollment(Long id);
    //public void removeAllStudent(Long student_id);
}
