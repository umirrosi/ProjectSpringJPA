package com.rapidtech.javaproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String FirstMidName;
    private String LastName;
    private Date EnrollmentDate;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    private List<PEnrollment> enrollment;

}
