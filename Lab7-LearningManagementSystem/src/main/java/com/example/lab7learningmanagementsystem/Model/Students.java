package com.example.lab7learningmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Students {

    private String studentName;
    private String studentId;


    @NotEmpty(message = "Course name can't be empty!")
    @Pattern(regexp = "Modeling and simulation|Advanced programming|Cybersecurity basics|Distributed computing|Software engineering",
            message = "Only these courses are available: Modeling and simulation, Advanced programming, Cybersecurity basics, Distributed computing, Software engineering")
    private String courseName;

    @NotEmpty(message = "Start date can't be empty!")
    private String startDate;

    @NotEmpty(message = "End date can't be empty!")
    private String endDate;


}
