package tests.model;
import model.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProductTest {

    // -------------------------
    // Constructor & Getters
    // -------------------------

    @Test
    public void testProductIdIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(1, p.getId());
    }

    @Test
    public void testProductNameIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals("Apple", p.getName());
    }

    @Test
    public void testProductPriceIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(0.99, p.getPrice(), 1e-6);
    }

    @Test
    public void testProductQuantityIsSetCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertEquals(50, p.getQuantity());
    }

    // -------------------------
    // Setters
    // -------------------------

    @Test
    public void testSetPriceUpdatesCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setPrice(1.49);
        assertEquals(1.49, p.getPrice(), 1e-6);
    }

    @Test
    public void testSetQuantityUpdatesCorrectly() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setQuantity(30);
        assertEquals(30, p.getQuantity());
    }

    @Test
    public void testSetQuantityToZero() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setQuantity(0);
        assertEquals(0, p.getQuantity());
    }

    @Test
    public void testSetPriceToZero() {
        Product p = new Product(1, "Apple", 0.99, 50);
        p.setPrice(0.0);
        assertEquals(0.0, p.getPrice(), 1e-6);
    }

    // -------------------------
    // toString
    // -------------------------

    @Test
    public void testToStringContainsId() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("1"));
    }

    @Test
    public void testToStringContainsName() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("Apple"));
    }

    @Test
    public void testToStringContainsPrice() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("0.99"));
    }

    @Test
    public void testToStringContainsQuantity() {
        Product p = new Product(1, "Apple", 0.99, 50);
        assertTrue(p.toString().contains("50"));
    }
}