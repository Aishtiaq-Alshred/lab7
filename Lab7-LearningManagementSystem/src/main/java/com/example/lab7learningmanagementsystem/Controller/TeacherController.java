package com.example.lab7learningmanagementsystem.Controller;

import com.example.lab7learningmanagementsystem.ApiResponse.ApiResponse;
import com.example.lab7learningmanagementsystem.Model.Teacher;
import com.example.lab7learningmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;



    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(200).body(service.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Teacher teacher) {
        boolean isAdded = service.addCourse(teacher);

        if (!isAdded) {
            return ResponseEntity.status(400).body(new ApiResponse("Course already exists for this teacher!"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully!"));
    }

    @PutMapping("/update/{teacherName}/{courseName}")
    public ResponseEntity updateCourse(@PathVariable String teacherName, @PathVariable String courseName, @RequestBody @Valid Teacher updatedTeacher) {

        boolean isUpdated = service.updateCourse(teacherName, courseName, updatedTeacher);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found for this teacher!"));
    }

    @DeleteMapping("/delete/{teacherName}/{courseName}")
    public ResponseEntity deleteCourse(@PathVariable String teacherName, @PathVariable String courseName) {
        boolean isDeleted = service.deleteCourse(teacherName, courseName);

        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found for this teacher!"));
    }

    @GetMapping("/students/{courseName}")
    public ResponseEntity getStudentsByCourse(@PathVariable String courseName) {
        ArrayList<String> students = service.getStudentsByCourse(courseName);

        if (students != null) {
            return ResponseEntity.status(200).body(students);
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found!"));
    }
}
