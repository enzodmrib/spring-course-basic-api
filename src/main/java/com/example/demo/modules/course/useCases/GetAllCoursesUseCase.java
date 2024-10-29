package com.example.demo.modules.course.useCases;

import com.example.demo.modules.course.CourseEntity;
import com.example.demo.modules.course.CourseRepository;
import com.example.demo.modules.course.enums.CourseCategoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCoursesUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(String name, CourseCategoryEnum category) {
        List<CourseEntity> courses = this.courseRepository.findAllByOptionalNameAndOptionalCategory(name, category);

        return courses;
    }
}
