package de.dhbw.databases.demo;

import java.sql.Date;
import java.util.Objects;

public class Item {

    private long id;
    private String title;
    private Date produced;
    private float price;

    public Item() {}

    public Item(long id, String title, Date produced, float price) {
        this.id = id;
        this.title = title;
        this.produced = produced;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getProduced() {
        return produced;
    }

    public void setProduced(Date produced) {
        this.produced = produced;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", produced=" + produced +
                ", price=" + price +
                '}';
    }
}