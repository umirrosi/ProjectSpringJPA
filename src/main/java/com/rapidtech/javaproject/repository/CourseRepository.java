package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.model.PCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<PCourse,Long> {
    List<CourseResDTO> findAllCourseByTitleContaining (String title);
}
