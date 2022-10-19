package com.rapidtech.javaproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;
    private String title;
    private int credits;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<PEnrollment> enrollment;

}
