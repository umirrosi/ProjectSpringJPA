package com.rapidtech.javaproject.service.Impl;

import com.rapidtech.javaproject.dto.*;
import com.rapidtech.javaproject.model.PCourse;
import com.rapidtech.javaproject.model.PEnrollment;
import com.rapidtech.javaproject.model.PStudent;
import com.rapidtech.javaproject.repository.CourseRepository;
import com.rapidtech.javaproject.repository.EnrollmentRepository;
import com.rapidtech.javaproject.repository.StudentRepository;
import com.rapidtech.javaproject.service.EnrollementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollementService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<EnrollmentResDTO> getAllEnrollment() {
        List<EnrollmentResDTO> enrollmentDtoList = new ArrayList<>();
        List<PEnrollment> enrollments = enrollmentRepository.findAll();
        for (PEnrollment enrollment : enrollments) {
            enrollmentDtoList.add(EnrollmentResDTO.builder()
                    .enrollment_id(enrollment.getEnrollment_id()).grade(enrollment.getGrade())
                    .dataStudent(
                            StudentResDTO.builder()
                                    .id(enrollment.getStudent().getId())
                                    .last_name(enrollment.getStudent().getLast_name())
                                    .first_mid_name(enrollment.getStudent().getFirst_mid_name())
                                    .enrollment_date(enrollment.getStudent().getEnrollment_date()).build())
                    .dataCourse(
                            CourseResDTO.builder()
                                    .course_id(enrollment.getCourse().getCourse_id())
                                    .title(enrollment.getCourse().getTitle())
                                    .credits(enrollment.getCourse().getCredits()).build())
                    .build());
        }
        return enrollmentDtoList;
    }

    @Override
    public EnrollmentReqDTO getEnrollmentById(Long id) {
        return null;
    }

    @Override
    public EnrollmentResDTO insertEnrollment(EnrollmentReqDTO enrollmentReqDto) {
        PEnrollment newEnrollment = new PEnrollment();
        newEnrollment.setGrade(enrollmentReqDto.getGrade());
        newEnrollment.setStudent(
                PStudent.builder().id(enrollmentReqDto.getStudent_id()).build());
        newEnrollment.setCourse(
                PCourse.builder().course_id(enrollmentReqDto.getCourse_id()).build());
        PEnrollment result = enrollmentRepository.save(newEnrollment);

        return EnrollmentResDTO.builder().enrollment_id(result.getEnrollment_id())
                .grade(result.getGrade())
                //.dataCourse(result.getCourse().getCourse_id())
                //.dataStudent(result.getStudent().getId())
                .build();
    }

    @Override
    public EnrollmentResDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto) {
        Optional<PEnrollment> updateEnrollment = enrollmentRepository.findById(id);
        PEnrollment result = new PEnrollment();
        if(updateEnrollment.isPresent()){
            PEnrollment enrollment = updateEnrollment.get();
            enrollment.setGrade(enrollmentReqDto.getGrade());
            result = enrollmentRepository.save(enrollment);
        }
        return  EnrollmentResDTO.builder().enrollment_id(result.getEnrollment_id())
                //.dataCourse(result.getCourse().getCourse_id())
                //.course(result.getCourse())
                .grade(result.getGrade()).build();
    }

    @Override
    public void deleteEnrollment(Long id) { enrollmentRepository.deleteById(id);
    }

}
