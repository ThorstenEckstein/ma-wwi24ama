package de.dhbw.solution.associations;

@SuppressWarnings("FieldCanBeLocal")
public class Student {
    private Course course;

    public void visits(Course course) {
        this.course = course;
    }
}
