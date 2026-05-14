package tests.model;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
// import org.junit.jupiter.api.BeforeEach;

import model.Ghaith;
import model.Product;
import java.util.List;

public class GhaithTest {
    private Ghaith testSystem;

    // Sets up a fresh system before every single test
    @Before
    public void setUp() {
        testSystem = new Ghaith(1, "Test Manager");
        // Pre-load some data for testing
        testSystem.addProductToSystem(new Product(101, "Apple", 1.0, 50));
        testSystem.addProductToSystem(new Product(102, "Banana", 0.5, 100));
    }

    @Test
    public void testRemoveProduct_Success() {
        boolean result = testSystem.removeProduct(101);
        assertTrue("Should return true for an existing product", result);
    }

    @Test
    public void testRemoveProduct_Fail() {
        boolean result = testSystem.removeProduct(999);
        assertFalse("Should return false for a non-existent ID", result);
    }

    @Test
    public void testSearchByName() {
        List<Product> results = testSystem.searchByName("App");
        assertEquals("Should find one product matching 'App'", 1, results.size());
        assertEquals("Apple", results.get(0).getName());
    }

    @Test
    public void testRemoveFromCart_InvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            testSystem.removeFromCart(-1);
        });
    }
}