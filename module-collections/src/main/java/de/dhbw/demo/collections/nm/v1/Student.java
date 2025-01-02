package de.dhbw.demo.collections.nm.v1;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Student /*extends Object*/ {

    Long id;

    String name;

    List<Course> courses;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    /* Step 1: activate 'default' equals()

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    */


    /* Step 2: activate 'custom' equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    */
}
