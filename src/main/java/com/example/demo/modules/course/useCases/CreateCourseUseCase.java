package com.example.demo.modules.course.useCases;

import com.example.demo.modules.course.CourseEntity;
import com.example.demo.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        CourseEntity course = this.courseRepository.save(courseEntity);

        return course;
    }
}
