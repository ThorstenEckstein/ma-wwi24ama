package de.dhbw.solution;

import de.dhbw.solution.associations.Course;
import de.dhbw.solution.associations.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssociationsSolutionTest {

    @Test
    @DisplayName("""
            Erstelle zwei Klassen 'Course' & 'Student'.
            "Der Kurs kann von mehreren Studierenden besucht werden"
            Setze diese Beziehung zwischen den zwei Klassen um.
            
            Speichere die Klassen im Paket "src/main/java/de/dhbw/exercise/associations"
            
            Zusatzfrage: Handelt es sich um eine "Aggregation" oder um eine "Komposition"?
            """)
    public void exercise1() {
        // given
        Course course = new Course();

        Student student1 = new Student();
        Student student2 = new Student();

        // when
        course.visitedBy(student1);
        course.visitedBy(student2);

        student1.visits(course);
        student2.visits(course);

        // then
        assertEquals(2, course.countParticipants());
    }

}