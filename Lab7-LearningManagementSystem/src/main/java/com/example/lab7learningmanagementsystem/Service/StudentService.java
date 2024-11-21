package com.example.lab7learningmanagementsystem.Service;


import com.example.lab7learningmanagementsystem.Model.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    private final ArrayList<Students> studentCoursesList = new ArrayList<>();


    public ArrayList<Students> getCourses() {
        return studentCoursesList;
    }


    public boolean addCourse(Students studentCourse) {
        if (!isDateValid(studentCourse)) {
            return false;
        }
        studentCoursesList.add(studentCourse);
        return true;
    }


    public boolean updateCourse(String courseName, Students updatedCourse) {
        for (int i = 0; i < studentCoursesList.size(); i++) {
            if (studentCoursesList.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                studentCoursesList.set(i, updatedCourse);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String courseName) {
        for (int i = 0; i < studentCoursesList.size(); i++) {
            if (studentCoursesList.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                studentCoursesList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean searchCourse(String courseName) {
        for (int i = 0; i < studentCoursesList.size(); i++) {
            if (studentCoursesList.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }


    private boolean isDateValid(Students studentCourse) {

        String startDate = studentCourse.getStartDate();
        String endDate = studentCourse.getEndDate();


        if (startDate == null || endDate == null) {
            return false;

        }
        return true;
    }


}

