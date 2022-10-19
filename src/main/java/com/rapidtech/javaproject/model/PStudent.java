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
    private Long id;
    private String first_mid_name;
    private String last_name;
    private Date enrollment_date;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<PEnrollment> enrollment;

}
