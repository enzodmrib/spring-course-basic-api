package com.example.demo.modules.course.dto;

import com.example.demo.modules.course.enums.CourseCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequestDTO {
    private String name;
    private CourseCategoryEnum category;
}
