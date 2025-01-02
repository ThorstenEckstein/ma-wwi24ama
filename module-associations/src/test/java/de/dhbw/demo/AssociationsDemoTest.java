package de.dhbw.demo;

import de.dhbw.demo.aggregation.Product;
import de.dhbw.demo.aggregation.ShoppingCart;
import de.dhbw.demo.associations.n.*;
import de.dhbw.demo.associations.nm.v2.Course;
import de.dhbw.demo.associations.nm.v2.Registration;
import de.dhbw.demo.associations.nm.v2.Student;
import de.dhbw.demo.composition.Life;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssociationsDemoTest {

    @Test
    @DisplayName("Demo 1: Aggregation")
    public void demo1() {
        // given
        ShoppingCart shoppingCart = new ShoppingCart("SC1234");
        Product p1 = new Product("Book");
        Product p2 = new Product("Shoes");

        // when
        shoppingCart.setProducts(List.of(p1,p2));

        // then
        assertEquals(2, shoppingCart.getProducts().size());

        // when
        shoppingCart.removeProducts();

        // then
        assertNotNull(shoppingCart);
        assertTrue(shoppingCart.isEmpty());
    }

    @Test
    @DisplayName("Demo 2: Komposition")
    public void demo2() {
        // given
        de.dhbw.demo.composition.Person jonas;

        jonas = Life.birth("Jonas");

        // when
        Life.comingOfAge(jonas, "38sh36sg");

        // when
        Life.death(jonas);

        // then (Bemerkung: Warum kommt hier eigentlich keine NullPointerException? => siehe Modul 'Referenzsemantik')
        assertNull(jonas.getPassport());

        jonas = null;
        assertNull(jonas);
    }

    @Test
    @DisplayName("Demo 3: 1:1 Assoziation")
    public void demo3() {
        // given
        Person person = new Person("Olaf");
        Passport passport = new Passport("sjw73h73hdkf8");

        // when
        person.setPassport(passport);
        person.deletePassport();

        // then
        assertNull(person.getPassport());
    }

    @Test
    @DisplayName("Demo 4a: 1:n Assoziation")
    public void demo4a() {
        // given
        Train1 train1 = new Train1();

        // when
        train1.addWagon(new Wagon1());
        train1.addWagon(new Wagon1());

        // then
        assertEquals(2, train1.wagons.size());
    }

    @Test
    @DisplayName("Demo 4b: 1:n Assoziation")
    public void demo4b() {
        // given
        Train2 train2 = new Train2();

        Wagon2 wagon2a = new Wagon2();
        Wagon2 wagon2b = new Wagon2();

        // Woher weiß der Wagon nun, zu welchem Zug er gehört?
        // Was muss gemacht werden, um dies sicherzustellen?

        // when
        train2.addWagon(wagon2a);
        train2.addWagon(wagon2b);

        // then
        assertEquals(2, train2.wagons.size());
    }

    @Test
    @DisplayName("Demo 5: n:m Assoziation")
    public void demo5() {
        // given
        Course course = new Course();
        course.id = 2024001L;

        Course course2 = new Course();
        course2.id = 2024002L;

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