package com.rapidtech.javaproject.service;

import com.rapidtech.javaproject.dto.CourseReqDTO;
import com.rapidtech.javaproject.dto.CourseResDTO;

import java.util.List;

public interface CourseService {
    List<CourseResDTO> getAllCourse();
    CourseReqDTO getCourseById(Long id);
    CourseResDTO insertCourse(CourseReqDTO courseReqDto);
    CourseResDTO updateCourse(Long id, CourseReqDTO courseReqDto);
    void deleteCourse(Long id);
}
