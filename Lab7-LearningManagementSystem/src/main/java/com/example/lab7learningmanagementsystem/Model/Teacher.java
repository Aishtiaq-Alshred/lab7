package com.example.lab7learningmanagementsystem.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "Teacher name cannot be empty!")
    private String name;

    @NotEmpty(message = "Course name cannot be empty!")
    private String courseName;

    private ArrayList<String> registeredStudents;
}
