package com.example.demo.modules.course;

import com.example.demo.modules.course.enums.CourseCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    @Query(value = "SELECT c FROM course c " +
            "WHERE (c.name ILIKE(CONCAT('%', :name, '%')) OR :name IS NULL) " +
            "AND (c.category = :category) OR :category IS NULL")
    List<CourseEntity> findAllByOptionalNameAndOptionalCategory(@Param("name") String name, @Param("category") CourseCategoryEnum category);
}
