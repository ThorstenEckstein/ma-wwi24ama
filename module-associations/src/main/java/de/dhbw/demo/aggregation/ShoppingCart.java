package de.dhbw.demo.aggregation;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final String id;

    // Aggregation
    private List<Product> products;

    public ShoppingCart(String id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void removeProducts() {
        setProducts(new ArrayList<>());
    }

    public boolean isEmpty() {
        return this.products != null && this.products.isEmpty();
    }
}
