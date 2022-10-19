package com.rapidtech.javaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResDTO {
    private Long enrollment_id;
    private int grade;
    private StudentResDTO dataStudent;
    private CourseResDTO dataCourse;
}
