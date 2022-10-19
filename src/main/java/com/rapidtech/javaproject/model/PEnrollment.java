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
public class PEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollment_id;
    private int grade;

    @ManyToOne
    @JoinColumn (name="course_id")
    PCourse course;

    @ManyToOne
    @JoinColumn (name="student_id")
    PStudent student;

}
