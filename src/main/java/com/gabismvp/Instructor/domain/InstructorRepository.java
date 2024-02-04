package com.gabismvp.Instructor.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // CRUD operations
    // Any additional query methods can be defined here
}