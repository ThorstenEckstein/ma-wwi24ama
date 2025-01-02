package de.dhbw.demo.associations.nm.v2;

import java.time.LocalDate;

public class Registration {

    public Long courseId;
    public Long studentId;

    // maybe some additional attributes
    // NOTE: without this, this class would be a so-called "key table"

    public LocalDate registrationDate;

    @Override
    public String toString() {
        return "Registration " + hashCode() + ": student " + studentId + " attends course " + courseId;
    }
}
