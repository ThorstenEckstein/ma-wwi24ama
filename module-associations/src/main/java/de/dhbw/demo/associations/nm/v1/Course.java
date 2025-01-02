package de.dhbw.demo.associations.nm.v1;

import java.util.HashSet;
import java.util.Set;

public class Course {

    Long id;

    Set<Student> students = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
