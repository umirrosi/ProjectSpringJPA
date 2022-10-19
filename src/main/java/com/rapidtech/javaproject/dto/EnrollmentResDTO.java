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
    private Long EnrollmentId;
    private int Grade;
    private StudentResDTO studentResDto;
    private CourseResDTO courseResDto;
}
