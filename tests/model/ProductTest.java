package tests.model;
import model.Product;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // -------------------------
    // Constructor & Getters
    // -------------------------

    @Test
    void testProductIdIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(1, p.getId());
    }

    @Test
    void testProductNameIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals("Apple", p.getName());
    }

    @Test
    void testProductPriceIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(0.99, p.getPrice());
    }

    @Test
    void testProductQuantityIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(50, p.getQuantity());
    }

    // -------------------------
    // Setters
    // -------------------------

    @Test
    void testSetPriceUpdatesCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setPrice(1.49);
        assertEquals(1.49, p.getPrice());
    }

    @Test
    void testSetQuantityUpdatesCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setQuantity(30);
        assertEquals(30, p.getQuantity());
    }

    @Test
    void testSetQuantityToZero() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setQuantity(0);
        assertEquals(0, p.getQuantity());
    }

    @Test
    void testSetPriceToZero() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setPrice(0.0);
        assertEquals(0.0, p.getPrice());
    }

    // -------------------------
    // toString
    // -------------------------

    @Test
    void testToStringContainsId() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("1"));
    }

    @Test
    void testToStringContainsName() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("Apple"));
    }

    @Test
    void testToStringContainsPrice() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("0.99"));
    }

    @Test
    void testToStringContainsQuantity() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("50"));
    }
}