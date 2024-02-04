package com.gabismvp.Course.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import com.gabismvp.Course.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Standard CRUD operations are provided by JpaRepository
}