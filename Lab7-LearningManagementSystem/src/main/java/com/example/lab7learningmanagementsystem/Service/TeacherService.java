package com.example.lab7learningmanagementsystem.Service;

import com.example.lab7learningmanagementsystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    private final ArrayList<Teacher> teachers = new ArrayList<>();


    public boolean addCourse(Teacher teacher) {
        for (Teacher t : teachers) {
            if (t.getName().equalsIgnoreCase(teacher.getName()) &&
                    t.getCourseName().equalsIgnoreCase(teacher.getCourseName())) {
                return false;
            }
        }
        teachers.add(teacher);
        return true;
    }


    public boolean updateCourse(String teacherName, String courseName, Teacher updatedTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher t = teachers.get(i);
            if (t.getName().equalsIgnoreCase(teacherName) &&
                    t.getCourseName().equalsIgnoreCase(courseName)) {
                teachers.set(i, updatedTeacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String teacherName, String courseName) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equalsIgnoreCase(teacherName) &&
                    teachers.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<String> getStudentsByCourse(String courseName) {
        for (Teacher t : teachers) {
            if (t.getCourseName().equalsIgnoreCase(courseName)) {
                return t.getRegisteredStudents();
            }
        }
        return null;
    }


    public ArrayList<Teacher> getAllTeachers() {
        return teachers;
    }
}

