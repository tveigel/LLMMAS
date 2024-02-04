package com.gabismvp.Owner.domain;

import com.gabismvp.Course.domain.Course;
import com.gabismvp.Instructor.domain.Instructor;
import com.gabismvp.Student.domain.Student;


import jakarta.persistence.*;
import java.util.Set;


@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OwnerID;

    @Column(nullable = false)
    private String name;

    @Column(name = "Contact Information", nullable = false)
    private String contactInformation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id") // No mappedBy, unidirectional
    private Set<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id") // No mappedBy, unidirectional
    private Set<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id") // No mappedBy, unidirectional
    private Set<Student> students;

    // Getters and Setters

    public long getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(long OwnerID) {
        this.OwnerID = OwnerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}