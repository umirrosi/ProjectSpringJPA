package com.rapidtech.javaproject.service.Impl;

import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.dto.StudentReqDTO;
import com.rapidtech.javaproject.dto.StudentResDTO;
import com.rapidtech.javaproject.dto.StudentWithCourseResDTO;
import com.rapidtech.javaproject.model.PEnrollment;
import com.rapidtech.javaproject.model.PStudent;
import com.rapidtech.javaproject.repository.StudentRepository;
import com.rapidtech.javaproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResDTO> getAllStudent() {
        List<PStudent> students = studentRepository.findAll();
        List<StudentResDTO> studentResDtoList = new ArrayList<>();
        for(PStudent student : students){
            studentResDtoList.add(StudentResDTO.builder()
                    .id(student.getId()).first_mid_name(student.getFirst_mid_name())
                    .last_name(student.getLast_name())
                    .enrollment_date(student.getEnrollment_date())
                    .build());
        }
        return studentResDtoList;
    }

    /*@Override
    public List<StudentResDTO> findAllStudentByFirstMidName(String first_mid_name) {
        return studentRepository.findAllStudentByFirstMidName(first_mid_name);
    }*/

    @Override
    public StudentReqDTO getStudentById(Long id) {
        StudentReqDTO studentReqDto = new StudentReqDTO();
        PStudent student = studentRepository.findById(id).orElse(new PStudent());
        studentReqDto.setFirst_mid_name(student.getFirst_mid_name());
        studentReqDto.setLast_name(student.getLast_name());
        studentReqDto.setEnrollment_date(student.getEnrollment_date());

        return studentReqDto;
    }

    @Override
    public StudentResDTO insertStudent(StudentReqDTO studentReqDto) {
            PStudent newStudent = PStudent.builder().first_mid_name(studentReqDto.getFirst_mid_name())
                    .last_name(studentReqDto.getLast_name())
                    .enrollment_date(studentReqDto.getEnrollment_date())
                    .build();
            PStudent result = studentRepository.save(newStudent);
            return StudentResDTO.builder().id(result.getId()).first_mid_name(studentReqDto.getFirst_mid_name())
                    .last_name(studentReqDto.getLast_name())
                    .enrollment_date(result.getEnrollment_date())
                    .build();
    }

    @Override
    public StudentResDTO updateStudent(Long id, StudentReqDTO studentReqDto) {
        PStudent editStudent = PStudent.builder().id(id).first_mid_name(studentReqDto.getFirst_mid_name())
                .last_name(studentReqDto.getLast_name())
                .enrollment_date(studentReqDto.getEnrollment_date())
                .build();
        PStudent result = studentRepository.save(editStudent);
        return StudentResDTO.builder().id(result.getId()).first_mid_name(result.getFirst_mid_name())
                .last_name(result.getLast_name())
                .enrollment_date(result.getEnrollment_date())
                .build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentWithCourseResDTO getStudentWithCourseById(Long id) {
        PStudent student = studentRepository.findById(id).get();
        List<PEnrollment> enrollmentList = student.getEnrollment();
        List<CourseResDTO> courseResDtoList = new ArrayList<>();
        for (PEnrollment enrollment : enrollmentList){
            courseResDtoList.add(CourseResDTO.builder()
                    .course_id(enrollment.getCourse().getCourse_id())
                    .title(enrollment.getCourse().getTitle())
                    .credits(enrollment.getCourse().getCredits()).build());
        }
        return StudentWithCourseResDTO.builder()
                .id(student.getId()).first_mid_name(student.getFirst_mid_name())
                .last_name(student.getLast_name())
                .enrollment_date(student.getEnrollment_date())
                .courses(courseResDtoList).build();
    }

    @Override
    public List<StudentWithCourseResDTO> getAllStudentWithCourse() {
        List<PStudent> students = studentRepository.findAll();
        List<StudentWithCourseResDTO> studentWithCourseResDtoList = new ArrayList<>();
        for (PStudent student : students){
            List<CourseResDTO> courseResDto  = new ArrayList<>();
            studentWithCourseResDtoList.add(
                    StudentWithCourseResDTO.builder()
                            .id(student.getId()).first_mid_name(student.getFirst_mid_name())
                            .last_name(student.getLast_name())
                            .enrollment_date(student.getEnrollment_date())
                            .courses(courseResDto).build());
            for(PEnrollment enrollment : student.getEnrollment()) {
                courseResDto.add(CourseResDTO.builder()
                        .course_id(enrollment.getCourse().getCourse_id())
                        .title(enrollment.getCourse().getTitle())
                        .credits(enrollment.getCourse().getCredits()).build());
            }
        }
        return studentWithCourseResDtoList;
    }
}
