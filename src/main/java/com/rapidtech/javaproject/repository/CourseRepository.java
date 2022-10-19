package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.model.PCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<PCourse,Long> {

}
