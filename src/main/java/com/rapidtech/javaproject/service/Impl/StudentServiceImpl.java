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
                    .Id(student.getId()).FirstMidName(student.getFirstMidName())
                    .LastName(student.getLastName())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentReqDTO getStudentById(Long id) {
        StudentReqDTO studentReqDto = new StudentReqDTO();
        PStudent student = studentRepository.findById(id).orElse(new PStudent());
        studentReqDto.setFirstMidName(student.getFirstMidName());
        studentReqDto.setLastName(student.getLastName());

        return studentReqDto;
    }

    @Override
    public StudentResDTO insertStudent(StudentReqDTO studentReqDto) {
            PStudent newStudent = PStudent.builder().FirstMidName(studentReqDto.getFirstMidName())
                    .LastName(studentReqDto.getLastName())
                    .EnrollmentDate(studentReqDto.getEnrollmentDate())
                    .build();
            PStudent result = studentRepository.save(newStudent);
            return StudentResDTO.builder().Id(result.getId()).FirstMidName(studentReqDto.getFirstMidName())
                    .LastName(studentReqDto.getLastName())
                    .EnrollmentDate(result.getEnrollmentDate())
                    .build();
    }

    @Override
    public StudentResDTO updateStudent(Long id, StudentReqDTO studentReqDto) {
        PStudent editStudent = PStudent.builder().Id(id).FirstMidName(studentReqDto.getFirstMidName())
                .LastName(studentReqDto.getLastName())
                .build();
        PStudent result = studentRepository.save(editStudent);
        return StudentResDTO.builder().Id(result.getId()).FirstMidName(result.getFirstMidName())
                .LastName(result.getLastName())
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
                .Id(student.getId())
                .LastName(student.getLastName())
                .FirstMidName(student.getFirstMidName())
                .EnrollmentDate(student.getEnrollmentDate())
                .courseResDtoList(courseResDtoList).build();
    }

    @Override
    public List<StudentWithCourseResDTO> getAllStudentWithCourse() {
        List<PStudent> students = studentRepository.findAll();
        List<StudentWithCourseResDTO> studentWithCourseResDtoList = new ArrayList<>();
        for (PStudent student : students){
            List<CourseResDTO> courseResDtoList  = new ArrayList<>();
            for(PEnrollment enrollment : student.getEnrollment()) {
                courseResDtoList.add(CourseResDTO.builder()
                        .course_id(enrollment.getCourse().getCourse_id())
                        .title(enrollment.getCourse().getTitle())
                        .credits(enrollment.getCourse().getCredits()).build());
            }
            studentWithCourseResDtoList.add(
                    StudentWithCourseResDTO.builder()
                            .Id(student.getId())
                            .LastName(student.getLastName())
                            .FirstMidName(student.getFirstMidName())
                            .EnrollmentDate(student.getEnrollmentDate())
                            .courseResDtoList(courseResDtoList).build()
            );
        }
        return studentWithCourseResDtoList;
    }
}
