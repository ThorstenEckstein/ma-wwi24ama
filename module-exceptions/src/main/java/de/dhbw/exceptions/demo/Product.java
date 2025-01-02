package de.dhbw.exceptions.demo;

import de.dhbw.commons.DateTimeUtil;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Product {

    private String name;
    private ZonedDateTime bestBeforeDate;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(ZonedDateTime bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name +
                ", bestBeforeDate=" + DateTimeUtil.asSimpleString(bestBeforeDate) + '}';
    }

}