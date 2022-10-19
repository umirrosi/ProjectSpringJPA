package com.rapidtech.javaproject.controller;

import com.rapidtech.javaproject.dto.CourseReqDTO;
import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.dto.EnrollmentReqDTO;
import com.rapidtech.javaproject.dto.EnrollmentResDTO;
import com.rapidtech.javaproject.service.EnrollementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Enrollments")
@RestController
public class EnrollmentController {
    @Autowired
    private EnrollementService enrollmentService;

    @GetMapping
    public List<EnrollmentResDTO> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResDTO insertEnrollment(@RequestBody EnrollmentReqDTO enrollmentReqDto)
    {
        return enrollmentService.insertEnrollment(enrollmentReqDto);
    }


}
