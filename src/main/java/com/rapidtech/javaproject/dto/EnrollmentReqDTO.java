package com.rapidtech.javaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentReqDTO {
    private int Grade;
    private Long course_id;
    private Long student_id;
}
