package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.model.PStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<PStudent,Long> {
}