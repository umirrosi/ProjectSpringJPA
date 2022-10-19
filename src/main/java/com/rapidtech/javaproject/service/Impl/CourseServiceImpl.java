package com.rapidtech.javaproject.service.Impl;

import com.rapidtech.javaproject.dto.CourseReqDTO;
import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.model.PCourse;
import com.rapidtech.javaproject.repository.CourseRepository;
import com.rapidtech.javaproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResDTO> getAllCourse() {
        List<PCourse> courses = courseRepository.findAll();
        List<CourseResDTO> courseResDtoList = new ArrayList<>();
        for(PCourse course : courses){
            courseResDtoList.add(CourseResDTO.builder()
                    .course_id(course.getCourse_id()).title(course.getTitle())
                    .credits(course.getCredits())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseReqDTO getCourseById(Long id) {
        CourseReqDTO courseReqDto = new CourseReqDTO();
        PCourse course = courseRepository.findById(id).orElse(new PCourse());
        courseReqDto.setTitle(course.getTitle());
        courseReqDto.setCredits(course.getCredits());

        return courseReqDto;
    }

    @Override
    public CourseResDTO insertCourse(CourseReqDTO courseReqDto) {
        PCourse newCourse = PCourse.builder().title(courseReqDto.getTitle())
                .credits(courseReqDto.getCredits())
                .build();
        PCourse result = courseRepository.save(newCourse);
        return CourseResDTO.builder().course_id(result.getCourse_id()).title(result.getTitle())
                .credits(result.getCredits())
                .build();
    }

    @Override
    public CourseResDTO updateCourse(Long id, CourseReqDTO courseReqDto) {
        PCourse editCourse = PCourse.builder().course_id(id).title(courseReqDto.getTitle())
                .credits(courseReqDto.getCredits())
                .build();
        PCourse result = courseRepository.save(editCourse);
        return CourseResDTO.builder().course_id(result.getCourse_id()).title(result.getTitle())
                .credits(result.getCredits())
                .build();
    }

    @Override
    public void deleteCourse(Long id)  {
        courseRepository.deleteById(id);
    }
}

