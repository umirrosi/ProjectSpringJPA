package com.rapidtech.javaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseWithStudentResDTO {
    private Long course_id;
    private String title;
    private Long credits;
    List<StudentResDTO> students;
}
