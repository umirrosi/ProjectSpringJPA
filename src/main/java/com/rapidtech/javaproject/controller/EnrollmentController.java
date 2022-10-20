package com.rapidtech.javaproject.controller;

import com.rapidtech.javaproject.dto.*;
import com.rapidtech.javaproject.model.PEnrollment;
import com.rapidtech.javaproject.service.EnrollementService;
import com.rapidtech.javaproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RequestMapping("/api/Enrollments")
@RestController
public class EnrollmentController {
    @Autowired
    private EnrollementService enrollmentService;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<EnrollmentResDTO> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String insertEnrollment(@RequestBody EnrollmentReqDTO enrollmentReqDto) {
        enrollmentService.insertEnrollment(enrollmentReqDto);
        return "Berhasil menambahkan student " + enrollmentReqDto.getStudent_id().toString() +
                " ke course " + enrollmentReqDto.getCourse_id().toString();
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String newStudentEnrollment(@RequestBody StudentReqDTO studentReqDto, EnrollmentReqDTO enrollmentReqDto)
    {
        studentService.insertStudent(studentReqDto);
        enrollmentService.insertEnrollment(enrollmentReqDto);
        return "Berhasil menambahkan student baru " + enrollmentReqDto.getStudent_id().toString()+
                " ke course "+ enrollmentReqDto.getCourse_id().toString();
    }*/

    @PutMapping("/{id}")
    public String updateEnrollment(@PathVariable("id") Long id,
                                   @RequestBody EnrollmentReqDTO enrollmentReqDto) {
        enrollmentService.updateEnrollment(id, enrollmentReqDto);
        return "Data enrollment id " + id.toString() + " berhasil di perbarui. Student id "
                + enrollmentReqDto.getStudent_id().toString() + " berhasil di tambah ke Course id "
                + enrollmentReqDto.getCourse_id().toString();
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable("id") Long id) {
        enrollmentService.deleteEnrollment(id);
        return "Data enrollment id " + id.toString() + " berhasil dihapus";
    }

    //@PostMapping("/{student_id}")
    //public String removeAllStudent(@PathVariable("student_id") Long student_id) {
      //  enrollmentService.removeAllStudent(student_id);
        //return "Data student id " + student_id.toString() + " pada semua course berhasil dihapus";
    //}
}
