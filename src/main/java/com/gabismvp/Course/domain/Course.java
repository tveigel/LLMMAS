package com.gabismvp.Course.domain;

import jakarta.persistence.*;

import com.gabismvp.Owner.domain.Owner;
import com.gabismvp.Instructor.domain.Instructor;
import com.gabismvp.Student.domain.Student;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private String time;

    @Column
    private String place;

    @Enumerated(EnumType.STRING)
    @Column
    private Level level;

    @Column(nullable = false)
    private Double fee;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToMany
    @JoinTable(name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

    public enum Level {
        BEGINNER, INTERMEDIATE, ADVANCED
    }

    // Getters and Setters
    // ... Generated Manually
}
