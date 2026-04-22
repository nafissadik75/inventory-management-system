package tests.model;

import org.junit.jupiter.api.Test;

import model.Inventory;
import model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandTest {
    @Test
    void TC1_singleProduct() {
        Inventory inv = new Inventory();
        Product p = new Product(1, "Apple", 0.99, 50);
        inv.addProduct(p);

        List<Product> result = inv.listProducts();

        assertEquals(1, result.size());
        assertTrue(result.contains(p));
    }

    @Test
    void TC2_threeProducts() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1.0, 1));
        inv.addProduct(new Product(2, "B", 2.0, 2));
        inv.addProduct(new Product(3, "C", 3.0, 3));

        List<Product> result = inv.listProducts();

        assertEquals(3, result.size());
    }

    @Test
    void TC3_emptyAfterRemove() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1.0, 1));
        inv.removeProductById(1);

        List<Product> result = inv.listProducts();

        assertTrue(result.isEmpty());
    }

    @Test
    void TC4_insertionOrder() {
        Inventory inv = new Inventory();
        for (int i = 1; i <= 5; i++) {
            inv.addProduct(new Product(i, "P" + i, i, i));
        }

        List<Product> result = inv.listProducts();

        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getId());
        }
    }

    @Test
    void TC5_noSideEffects() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1, 1));
        inv.addProduct(new Product(2, "B", 2, 2));

        List<Product> first = inv.listProducts();
        List<Product> second = inv.listProducts();

        assertEquals(first, second);
    }

    // Edge Cases

    @Test
    void EC1_emptyInventory() {
        Inventory inv = new Inventory();

        List<Product> result = inv.listProducts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void EC2_largeInventory() {
        Inventory inv = new Inventory();

        for (int i = 0; i < 1000; i++) {
            inv.addProduct(new Product(i, "P" + i, i, i));
        }

        List<Product> result = inv.listProducts();

        assertEquals(1000, result.size());
    }

    @Test
    void EC3_liveData() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1, 1));

        List<Product> first = inv.listProducts();
        assertEquals(1, first.size());

        inv.addProduct(new Product(2, "B", 2, 2));

        List<Product> second = inv.listProducts();
        assertEquals(2, second.size());
    }

    @Test
    void EC4_sameNameDifferentIds() {
        Inventory inv = new Inventory();
        Product p1 = new Product(1, "Same", 1, 1);
        Product p2 = new Product(2, "Same", 2, 2);

        inv.addProduct(p1);
        inv.addProduct(p2);

        List<Product> result = inv.listProducts();

        assertEquals(2, result.size());
        assertTrue(result.contains(p1));
        assertTrue(result.contains(p2));
    }

    @Test
    void EC5_zeroQuantityIncluded() {
        Inventory inv = new Inventory();
        Product p = new Product(1, "Zero", 1, 0);
        inv.addProduct(p);

        List<Product> result = inv.listProducts();

        assertTrue(result.contains(p));
    }

    // Error Handling

    @Test
    void EH1_defensiveCopy() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "A", 1, 1));

        List<Product> result = inv.listProducts();

        assertThrows(UnsupportedOperationException.class, result::clear);

        // Ensure internal list unaffected
        assertEquals(1, inv.listProducts().size());
    }

    @Test
    void EH2_nullInventoryReference() {
        Inventory inv = null;

        assertThrows(NullPointerException.class, () -> {
            inv.listProducts();
        });
    }
}
