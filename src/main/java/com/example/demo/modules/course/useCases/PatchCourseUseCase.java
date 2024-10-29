package com.example.demo.modules.course.useCases;

import com.example.demo.modules.course.CourseEntity;
import com.example.demo.modules.course.CourseRepository;
import com.example.demo.modules.course.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatchCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id) throws CourseNotFoundException {
        CourseEntity course = this.courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

        course.setActive(!course.getActive());

        CourseEntity result = this.courseRepository.save(course);

        return result;
    }

}
