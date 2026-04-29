package tests.model;
import org.junit.jupiter.api.Test;

import model.Inventory;
import model.Product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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





    
    // Searchbyname feature TestSuite
        @Test
    void testSearchFindsSingleMatch() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));
        inv.addProduct(new Product(2, "Banana", 1.0, 10));

        List<Product> results = inv.searchByName("app");

        assertEquals(1, results.size());
    }

    @Test
    void testSearchFindsMultipleMatches() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));
        inv.addProduct(new Product(2, "Pineapple", 1.0, 10));
        inv.addProduct(new Product(3, "Banana", 1.0, 10));

        List<Product> results = inv.searchByName("apple");

        assertEquals(2, results.size());
    }

    @Test
    void testSearchIsCaseInsensitive() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        List<Product> results = inv.searchByName("APPLE");

        assertEquals(1, results.size());
    }

    @Test
    void testSearchNoMatches() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        List<Product> results = inv.searchByName("orange");

        assertTrue(results.isEmpty());
    }

    @Test
    void testSearchWithEmptyString() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        List<Product> results = inv.searchByName("");

        assertTrue(results.isEmpty());
    }

    @Test
    void testSearchWithNull() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        List<Product> results = inv.searchByName(null);

        assertTrue(results.isEmpty());
    }

    @Test
    void testSearchWithWhitespaceOnly() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Apple", 1.0, 10));

        List<Product> results = inv.searchByName("   ");

        assertTrue(results.isEmpty());
    }

    @Test
    void testSearchPartialMatch() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Strawberry", 1.0, 10));

        List<Product> results = inv.searchByName("berry");

        assertEquals(1, results.size());
    }

    @Test
    void testSearchEmptyInventory() {
        Inventory inv = new Inventory();

        List<Product> results = inv.searchByName("apple");

        assertTrue(results.isEmpty());
    }
}