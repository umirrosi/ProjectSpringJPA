package com.rapidtech.javaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentWithCourseReqDTO {
    private String first_mid_name;
    private String last_name;
    private Date enrollment_date;
    private Long course_id;
    private Long student_id;
    private int grade;
}
