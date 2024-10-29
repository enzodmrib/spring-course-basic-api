package com.example.demo.modules.course.useCases;

import com.example.demo.modules.course.CourseEntity;
import com.example.demo.modules.course.CourseRepository;
import com.example.demo.modules.course.dto.UpdateCourseRequestDTO;
import com.example.demo.modules.course.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UpdateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, UpdateCourseRequestDTO courseDTO) throws CourseNotFoundException {
        CourseEntity course = this.courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

        course.setUpdatedAt(new Date());
        course.setName(courseDTO.getName());
        course.setCategory(courseDTO.getCategory());

        this.courseRepository.save(course);

        return course;
    }
}
