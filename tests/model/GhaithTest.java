package tests.model;
import org.junit.jupiter.api.Test;

import model.Inventory;
import model.Product;

import static org.junit.jupiter.api.Assertions.*;

public class GhaithTest {

    // Remove Product-feature TestSuite
    @Test
    void testRemoveExistingProduct() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        assertTrue(inv.removeProduct(1));
    }

    @Test
    void testRemoveProductReducesSize() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        inv.removeProduct(1);

        assertEquals(0, inv.size());
    }

    @Test
    void testRemoveSpecificProductOnly() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1.0, 10));
        inv.addProduct(new Product(2, "B", 1.0, 10));
        inv.addProduct(new Product(3, "C", 1.0, 10));

        inv.removeProduct(2);

        assertFalse(inv.removeProduct(2)); // already removed
        assertTrue(inv.removeProduct(1));
        assertTrue(inv.removeProduct(3));
    }

    @Test
    void testRemoveLastProduct() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(3, "Only", 1.0, 1));

        assertTrue(inv.removeProduct(3));
        assertEquals(0, inv.size());
    }

    @Test
    void testRemoveSameProductTwice() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        assertTrue(inv.removeProduct(1));
        assertFalse(inv.removeProduct(1));
    }

    @Test
    void testRemoveNonExistentProduct() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        assertFalse(inv.removeProduct(999));
    }

    @Test
    void testRemoveFromEmptyInventory() {
        Inventory inv = new Inventory();

        assertFalse(inv.removeProduct(1));
    }

    @Test
    void testRemoveAllProductsOneByOne() {
        Inventory inv = new Inventory();

        for (int i = 1; i <= 5; i++) {
            inv.addProduct(new Product(i, "P" + i, 1.0, 1));
        }

        for (int i = 1; i <= 5; i++) {
            assertTrue(inv.removeProduct(i));
        }

        assertEquals(0, inv.size());
    }

    @Test
    void testInvalidIdZero() {
        Inventory inv = new Inventory();

        assertThrows(IllegalArgumentException.class, () -> inv.removeProduct(0));
    }

    @Test
    void testInvalidNegativeId() {
        Inventory inv = new Inventory();

        assertThrows(IllegalArgumentException.class, () -> inv.removeProduct(-1));
    }
}