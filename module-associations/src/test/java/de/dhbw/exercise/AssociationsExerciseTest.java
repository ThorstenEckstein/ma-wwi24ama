package de.dhbw.exercise;

import de.dhbw.demo.associations.nm.v2.Course;
import de.dhbw.demo.associations.nm.v2.Registration;
import de.dhbw.demo.associations.nm.v2.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AssociationsExerciseTest {

    @Test
    @DisplayName("Übung 1: n:m zwischen Course & Student")
    public void exercise1() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("Übung 2: 'getter' und 'setter' anstelle direktem Feld-Zugriff")
    public void exercise2() {
        // given
        Course course = new Course();
        course.id = 2023001L;

        Course course2 = new Course();
        course2.id = 2023002L;

        Student alex = new Student();
        alex.id = 1L;

        Student dana = new Student();
        dana.id = 2L;

        Registration reg1 = new Registration();
        Registration reg2 = new Registration();
        Registration reg3 = new Registration();

        // when
        reg1.courseId = course.id;
        reg1.studentId = dana.id;
        reg1.registrationDate = LocalDate.now();

        reg2.courseId = course.id;
        reg2.studentId = alex.id;
        reg2.registrationDate = LocalDate.now();

        reg3.courseId = course2.id;
        reg3.studentId = alex.id;
        reg3.registrationDate = LocalDate.now();

        // then
        // no asserts here, just for demonstration
        System.out.println(reg1);
        System.out.println(reg2);
        System.out.println(reg3);
    }

}