package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.CourseReqDTO;
import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.dto.CourseWithStudentResDTO;
import com.rapidtech.javaproject.dto.StudentWithCourseResDTO;

import java.util.List;

public interface CourseService {
    List<CourseResDTO> getAllCourse();
    CourseReqDTO getCourseById(Long id);
    CourseResDTO insertCourse(CourseReqDTO courseReqDto);
    CourseResDTO updateCourse(Long id, CourseReqDTO courseReqDto);
    void deleteCourse(Long id);
    CourseWithStudentResDTO getCourseWithStudentById(Long id);
}
