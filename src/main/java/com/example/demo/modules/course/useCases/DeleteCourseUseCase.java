package com.example.demo.modules.course.useCases;

import com.example.demo.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
       this.courseRepository.deleteById(id);
    }
}
