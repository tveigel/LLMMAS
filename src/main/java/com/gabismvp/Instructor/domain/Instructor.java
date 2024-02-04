package com.gabismvp.Instructor.domain;

import jakarta.persistence.*;
import com.gabismvp.Course.domain.Course; // Assuming Course is in the same package
import com.gabismvp.Owner.domain.Owner;       // Assuming Owner is in the package Owner.domain
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String specialty;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    // Constructor, Getters and Setters
    
    public Instructor() {
    }

    public Long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Long instructorID) {
        this.instructorID = instructorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    // hashCode, equals, and toString methods can be generated as needed
    
    // other methods
}