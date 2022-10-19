package com.rapidtech.javaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithCourseResDTO {
    private Long Id;
    private String FirstMidName;
    private String LastName;
    private Date EnrollmentDate;
    List<CourseResDTO> courseResDtoList;
}
