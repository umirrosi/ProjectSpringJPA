package com.rapidtech.javaproject.controller;

import com.rapidtech.javaproject.dto.CourseReqDTO;
import com.rapidtech.javaproject.dto.CourseResDTO;
import com.rapidtech.javaproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResDTO> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public CourseReqDTO getByCourseId(@PathVariable("id") Long id)
    {

        return courseService.getCourseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResDTO insertCourse(@RequestBody CourseReqDTO courseReqDto)
    {
        return courseService.insertCourse(courseReqDto);
    }

    @PutMapping("/{id}")
    public CourseResDTO updateCourse(@PathVariable("id") Long id,
                                       @RequestBody CourseReqDTO courseReqDto)
    {
        return courseService.updateCourse(id, courseReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "Data id " + id.toString() + " berhasil dihapus";
    }
}
