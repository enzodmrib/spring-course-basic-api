package com.example.demo.modules.course.exceptions;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("Course not found");
    }
}
