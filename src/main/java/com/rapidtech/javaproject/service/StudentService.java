package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.StudentReqDTO;
import com.rapidtech.javaproject.dto.StudentResDTO;
import com.rapidtech.javaproject.dto.StudentWithCourseResDTO;

import java.util.List;

public interface StudentService {
    List<StudentResDTO> getAllStudent();
    //List<StudentResDTO> findAllStudentByFirstMidName(String first_mid_name);
    StudentReqDTO getStudentById(Long id);
    StudentResDTO insertStudent(StudentReqDTO studentReqDto);
    StudentResDTO updateStudent(Long id, StudentReqDTO studentReqDto);
    void deleteStudent(Long id);
    StudentWithCourseResDTO getStudentWithCourseById(Long id);
    List<StudentWithCourseResDTO> getAllStudentWithCourse();
}
