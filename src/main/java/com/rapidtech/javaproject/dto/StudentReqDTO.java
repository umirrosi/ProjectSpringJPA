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
public class StudentReqDTO {
    private String FirstMidName;
    private String LastName;
    private Date EnrollmentDate;
}
