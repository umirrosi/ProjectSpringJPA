package com.rapidtech.javaproject.service.Impl;

import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.dto.EnrollmentReqDTO;
import com.rapidtech.javaproject.dto.EnrollmentResDTO;
import com.rapidtech.javaproject.dto.StudentResDTO;
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
                    .EnrollmentId(enrollment.getEnrollmentId()).Grade(enrollment.getGrade())
                    .studentResDto(
                            StudentResDTO.builder()
                                    .Id(enrollment.getStudent().getId())
                                    .LastName(enrollment.getStudent().getLastName())
                                    .FirstMidName(enrollment.getStudent().getFirstMidName())
                                    .EnrollmentDate(enrollment.getStudent().getEnrollmentDate()).build())
                    .courseResDto(
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
                PStudent.builder().Id(enrollmentReqDto.getStudent_id()).build());
        newEnrollment.setCourse(
                PCourse.builder().course_id(enrollmentReqDto.getCourse_id()).build());
        PEnrollment result = enrollmentRepository.save(newEnrollment);
        return EnrollmentResDTO.builder().EnrollmentId(result.getEnrollmentId())
                .Grade(result.getGrade()).build();
    }

    @Override
    public EnrollmentResDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto) {
        return null;
    }

    @Override
    public void deleteEnrollment(Long id) { enrollmentRepository.deleteById(id);
    }

}
