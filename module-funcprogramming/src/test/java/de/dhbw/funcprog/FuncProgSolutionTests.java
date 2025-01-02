package de.dhbw.funcprog;

import de.dhbw.funcprog.solution.Product;
import de.dhbw.funcprog.solution.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FuncProgSolutionTests {

    @Test
    @DisplayName("Exercise 1 - loop with lambda")
    public void solution1() {
        // given
        List<Boolean> list = List.of(true,false,true,false);

        // when
        list.stream().forEach(item -> System.out.println(item));
        // list.forEach(System.out::println);

        // then - nothing to assert here
    }

    @Test
    @DisplayName("Übung 2a: Calculate a total in old fashioned way")
    public void solution2a() {
        // given - a list of at least 10 random Integers
        List<Double> list = List.of(1.0, 34.9, 34.23, 47.11);

        // when - loop over the list and calculate the total
        double sum = 0.0;

        for (Double value : list) {
            sum += value;
        }

        // then - assert the correct total
        assertEquals(117.24, sum);
    }

    @Test
    @DisplayName("Übung 2b: Calculate a total the modern way")
    public void solution2b() {
        // given - a list of at least 10 random Integers
        List<Double> list = List.of(1.0, 34.9, 34.23, 47.11);

        // when - loop over the list and calculate the total (3 variants)
        double sum1 = list.stream().reduce(0.0 , (val1, val2) -> val1 + val2);
        double sum2 = list.stream().mapToDouble(d -> d.doubleValue()).sum();
        double sum3 = list.stream().mapToDouble(Double::doubleValue).sum();

        // then - assert the correct total
        assertEquals(117.24, sum1);
        assertEquals(117.24, sum2);
        assertEquals(117.24, sum3);
    }

    @Test
    @DisplayName("""
            Übung 3: Für einen Warenkorb gilt es, darin enthaltene Produkte (mind. 3) zu nach
            ihrer Produktkategorie zu filtern.
            Optional: Ermittle den gesamten Preis des Warenkorbs als Summe der produkt-
            spezifischen Einzel-Preise.
            """)
    public void solution3() {
        // given
        ShoppingCart shoppingCart = ShoppingCart.of(
            new Product("Apple",      Product.Category.Food,    1.49),
            new Product("Smartphone", Product.Category.NonFood, 299.00),
            new Product("Glibber",    Product.Category.Unknown, 0.0)
        );

        // when
        List<Product> filteredProducts = shoppingCart.getProducts()
                .stream()
                .filter(p -> p.getCategory().equals(Product.Category.Food))
                .toList();

        double total = shoppingCart.getProducts().stream().mapToDouble(Product::getPrice).sum();

        // then
        assertEquals(1, filteredProducts.size());
        assertEquals(300.49, total);
    }

}