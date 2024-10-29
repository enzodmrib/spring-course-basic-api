package com.example.demo.modules.course.dto;


import com.example.demo.modules.course.enums.CourseCategoryEnum;
import lombok.Data;

@Data
public class CreateCourseRequestDTO {
    private String name;
    private CourseCategoryEnum category;
}
