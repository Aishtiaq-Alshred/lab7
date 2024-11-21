package com.example.lab7learningmanagementsystem.Controller;

import com.example.lab7learningmanagementsystem.ApiResponse.ApiResponse;
import com.example.lab7learningmanagementsystem.Model.Students;
import com.example.lab7learningmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/studentCourses")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        ArrayList<Students> courses = service.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Students studentCourse) {
        boolean isAdded = service.addCourse(studentCourse);

        if (!isAdded) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid course data or dates!"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully!"));
    }

    @PutMapping("/update/{courseName}")
    public ResponseEntity updateCourse(@PathVariable String courseName, @RequestBody @Valid Students updatedCourse) {
        boolean isUpdated = service.updateCourse(courseName, updatedCourse);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found!"));
    }

    @DeleteMapping("/delete/{courseName}")
    public ResponseEntity deleteCourse(@PathVariable String courseName) {
        boolean isDeleted = service.deleteCourse(courseName);

        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found!"));
    }

    @GetMapping("/search/{courseName}")
    public ResponseEntity searchCourse(@PathVariable String courseName) {
        boolean isFound = service.searchCourse(courseName);

        if (isFound) {
            return ResponseEntity.status(200).body(new ApiResponse("Course found!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course not found!"));
    }




}
