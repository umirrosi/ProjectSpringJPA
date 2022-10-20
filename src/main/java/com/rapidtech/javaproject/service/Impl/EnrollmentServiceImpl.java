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
                .dataStudent(StudentResDTO.builder().id(enrollmentReqDto.getStudent_id()).build())
                .dataCourse(CourseResDTO.builder().course_id(enrollmentReqDto.getCourse_id()).build())
                .build();

    }

    /*@Override
    public EnrollmentResDTO newStudentEnrollment(NewStudentWithCourseReqDTO newStudentWithCourseReqDTO) {
        PStudent newStudent = PStudent.builder().first_mid_name(newStudentWithCourseReqDTO.getFirst_mid_name())
                .last_name(newStudentWithCourseReqDTO.getLast_name())
                .enrollment_date(newStudentWithCourseReqDTO.getEnrollment_date())
                .build();
        PStudent student = studentRepository.save(newStudent);

        PEnrollment newEnrollment = new PEnrollment();
        newEnrollment.setGrade(newStudentWithCourseReqDTO.getGrade());
        newEnrollment.setStudent(
                PStudent.builder().id(newStudentWithCourseReqDTO.getStudent_id()).build());
        newEnrollment.setCourse(
                PCourse.builder().course_id(newStudentWithCourseReqDTO.getCourse_id()).build());
        PEnrollment result = enrollmentRepository.save(newEnrollment);

        return EnrollmentResDTO.builder().build();
     /*enrollment_id(result.getEnrollment_id())
                .grade(result.getGrade())
                .dataStudent(StudentResDTO.builder().id(enrollmentReqDto.getStudent_id()).build())
                .dataCourse(CourseResDTO.builder().course_id(enrollmentReqDto.getCourse_id()).build())
                .build();*/


    @Override
    public EnrollmentDTO updateEnrollment(Long id, EnrollmentReqDTO enrollmentReqDto) {
        Optional<PEnrollment> editEnrollment = enrollmentRepository.findById(id);
        PEnrollment result = new PEnrollment();

        if(editEnrollment.isPresent()){
            PEnrollment enrollment = editEnrollment.get();
            enrollment.setStudent(PStudent.builder().id(enrollmentReqDto.getStudent_id()).build());
            enrollment.setCourse(PCourse.builder().course_id(enrollmentReqDto.getCourse_id()).build());
            //enrollment.getStudent().setId(enrollmentReqDto.getStudent_id());
            //enrollment.getCourse().setCourse_id(enrollmentReqDto.getCourse_id());
            enrollment.setGrade(enrollmentReqDto.getGrade());
            result = enrollmentRepository.save(enrollment);
        }
        return  EnrollmentDTO.builder()
                .enrollment_id(result.getEnrollment_id())
                .grade(result.getGrade())
                //.dataStudent(EnrollmentStudentResDTO.builder().id(enrollmentReqDto.getStudent_id()).build())
                //.dataCourse(EnrollmentCourseResDTO.builder().course_id(enrollmentReqDto.getCourse_id()).build())
                .build();
    }

    @Override
    public void deleteEnrollment(Long id) { enrollmentRepository.deleteById(id);
    }

   // @Override
    //public void removeAllStudent(Long student_id) {
    //    enrollmentRepository.removeAllStudentContaining(student_id);
    //}


}
