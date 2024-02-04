# Database Schema Checklist

## [x] Entity: Owner

### Attributes:
- [ ] OwnerID (Primary Key)
- [ ] Name
- [ ] Contact Information

### Relationships:
- [ ] **Owner to Instructors**: One-to-Many. An owner can create and delete multiple instructors. This relationship should be unidirectional from Owner to Instructor without a corresponding `mappedBy` in the Instructor entity.
- [ ] **Owner to Courses**: One-to-Many. An owner can create and delete multiple courses. This relationship should be unidirectional from Owner to Course without a corresponding `mappedBy` in the Course entity.
- [ ] **Owner to Students**: One-to-Many. An owner can create and delete multiple students. This relationship should be unidirectional from Owner to Student without a corresponding `mappedBy` in the Student entity.

---

## [x] Entity: Instructor

### Attributes:
- [ ] InstructorID (Primary Key)
- [ ] Name
- [ ] Email
- [ ] Specialty

### Relationships:
- [ ] **Instructor to Courses**: One-to-Many. An instructor must teach one or more courses. The `Course` entity should contain a `mappedBy` attribute pointing back to the `Instructor`.
- [ ] **Instructor to Students (Indirect through Courses)**: Many-to-Many. An instructor can view all students in the courses they teach, indirectly through the courses. This relationship is managed via the Course entity and does not require direct mapping in the Instructor entity.
- [ ] **Instructor to Owner**: Many-to-One. Each instructor is created by an owner. The `Instructor` entity should use `@JoinColumn` to reference the `Owner`.

---

## [x] Entity: Course

### Attributes:
- [ ] CourseID (Primary Key)
- [ ] Title
- [ ] Description
- [ ] Time
- [ ] Place
- [ ] Level (Beginner, Intermediate, Advanced)
- [ ] Fee
- [ ] InstructorID (Foreign Key)

### Relationships:
- [ ] **Course to Owner**: Many-to-One. Each course is created and can be deleted by an owner. The `Course` entity should use `@JoinColumn` to reference the `Owner`.
- [ ] **Course to Instructor**: Many-to-One. Each course is taught by exactly one instructor. The `Course` entity should use `@JoinColumn` to reference the `Instructor`.
- [ ] **Courses to Students**: Many-to-Many. A course can have many students, and a student can enroll in many courses. This relationship should be managed via a junction table (e.g., Course_Student), with the `Course` entity containing a `@ManyToMany` annotation and using `@JoinTable` to define the relationship.

---

## [x] Entity: Student

### Attributes:
- [ ] StudentID (Primary Key)
- [ ] Name
- [ ] Address
- [ ] Email
- [ ] Skill Level (e.g., Beginner, Intermediate, Advanced)

### Relationships:
- [ ] **Students to Owner**: Many-to-One. Each student can be created and possibly deleted by an owner. The `Student` entity should use `@JoinColumn` to reference the `Owner`.
- [ ] **Students to Courses**: Many-to-Many. A student can enroll in many courses, and a course can have many students. This relationship should be managed via a junction table (e.g., Course_Student), with the `Student` entity containing a `@ManyToMany` annotation and using `@JoinTable` to define the relationship.
- [ ] **Students to Instructors (Indirect through Courses)**: Many-to-Many. A student can be indirectly linked to multiple instructors through the courses they are enrolled in. This relationship is managed via the Course entity and does not require direct mapping in the Student entity.
