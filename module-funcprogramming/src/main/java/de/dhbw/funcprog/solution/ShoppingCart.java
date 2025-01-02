package de.dhbw.funcprog.solution;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static ShoppingCart of(Product... products) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProducts(List.of(products));
        return shoppingCart;
    }
}
