package de.dhbw.solution.associations;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Course {
    private List<Student> students = new ArrayList<>();

    public void visitedBy(Student student) {
        this.students.add(student);
    }

    public int countParticipants() {
        return this.students.size();
    }
}
