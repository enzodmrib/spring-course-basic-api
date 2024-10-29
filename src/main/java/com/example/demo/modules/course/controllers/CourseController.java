package com.example.demo.modules.course.controllers;

import com.example.demo.modules.course.CourseEntity;
import com.example.demo.modules.course.dto.CreateCourseRequestDTO;
import com.example.demo.modules.course.dto.UpdateCourseRequestDTO;
import com.example.demo.modules.course.enums.CourseCategoryEnum;
import com.example.demo.modules.course.exceptions.CourseNotFoundException;
import com.example.demo.modules.course.useCases.*;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private PatchCourseUseCase patchCourseUseCase;

    @Autowired
    private GetAllCoursesUseCase getAllCoursesUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDTO courseDTO) {
        CourseEntity course = CourseEntity.builder()
                .active(true)
                .category(courseDTO.getCategory())
                .name(courseDTO.getName())
                .build();

        CourseEntity result = this.createCourseUseCase.execute(course);

        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody UpdateCourseRequestDTO courseDTO) {
         try {
             CourseEntity course = this.updateCourseUseCase.execute(id, courseDTO);

             return ResponseEntity.ok().body(course);
         } catch (CourseNotFoundException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patch(@PathVariable UUID id) {
        try {
            CourseEntity course = this.patchCourseUseCase.execute(id);

            return ResponseEntity.ok().body(course);
        } catch(CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) CourseCategoryEnum category) {
        try {
            List<CourseEntity> courses = this.getAllCoursesUseCase.execute(name, category);

            return ResponseEntity.ok().body(courses);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        this.deleteCourseUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }

}
