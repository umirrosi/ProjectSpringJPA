package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.model.PEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<PEnrollment,Long> {

}
