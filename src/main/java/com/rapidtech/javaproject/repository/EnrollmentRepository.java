package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.dto.EnrollmentResDTO;
import com.rapidtech.javaproject.model.PEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<PEnrollment,Long> {
    void removeAllStudentContaining(Long student_id);
}
