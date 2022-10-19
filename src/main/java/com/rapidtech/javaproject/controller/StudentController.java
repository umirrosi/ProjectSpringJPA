package com.rapidtech.javaproject.controller;

import com.rapidtech.javaproject.dto.StudentReqDTO;
import com.rapidtech.javaproject.dto.StudentResDTO;
import com.rapidtech.javaproject.dto.StudentWithCourseResDTO;
import com.rapidtech.javaproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Students")
@RestController

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResDTO> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentReqDTO getByStudentId(@PathVariable("id") Long id)
    {

        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResDTO insertStudent(@RequestBody StudentReqDTO studentReqDto)
    {
        return studentService.insertStudent(studentReqDto);
    }

    @PutMapping("/{id}")
    public StudentResDTO updateStudent(@PathVariable("id") Long id,
                                       @RequestBody StudentReqDTO studentReqDto)
    {
        return studentService.updateStudent(id, studentReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "Data id " + id.toString() + " berhasil dihapus";
    }

    @GetMapping("/withcourse/{id}")
    public StudentWithCourseResDTO getStudentWithCourseById(@PathVariable("id") Long id){
        return studentService.getStudentWithCourseById(id);
    }

    @GetMapping("/studentwithcourse")
    public List<StudentWithCourseResDTO> getAllWithCourse() {
        return studentService.getAllStudentWithCourse();
    }


}
