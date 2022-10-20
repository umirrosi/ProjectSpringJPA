package com.rapidtech.javaproject.repository;

import com.rapidtech.javaproject.dto.StudentResDTO;
import com.rapidtech.javaproject.model.PStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<PStudent,Long> {
    //List<StudentResDTO> findAllStudentByFirstMidName(String first_mid_name);
}