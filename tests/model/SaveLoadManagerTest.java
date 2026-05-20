package tests.model;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import model.Product;
import model.SaveLoadManager;

public class SaveLoadManagerTest {

    private final String TEST_FILE = "test_products.csv";

    @AfterEach
    public void cleanup() {
        File file = new File(TEST_FILE);

        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveProductsSuccessfully() {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 1200.50, 5));
        products.add(new Product(2, "Mouse", 20.00, 10));

        boolean result = SaveLoadManager.saveProducts(products, TEST_FILE);

        assertTrue(result);
    }

    @Test
    public void testLoadProductsSuccessfully() {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 1200.50, 5));

        SaveLoadManager.saveProducts(products, TEST_FILE);

        ArrayList<Product> loaded = SaveLoadManager.loadProducts(TEST_FILE);

        assertEquals(1, loaded.size());
        assertEquals("Laptop", loaded.get(0).getName());
    }

    @Test
    public void testSaveNullProducts() {

        boolean result = SaveLoadManager.saveProducts(null, TEST_FILE);

        assertFalse(result);
    }

    @Test
    public void testLoadNonExistentFile() {

        ArrayList<Product> loaded = SaveLoadManager.loadProducts("missing.csv");

        assertEquals(0, loaded.size());
    }

    @Test
    public void testLoadEmptyPath() {

        ArrayList<Product> loaded = SaveLoadManager.loadProducts("");

        assertEquals(0, loaded.size());
    }
}