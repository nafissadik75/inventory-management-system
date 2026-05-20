package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.CheckoutManager;
import model.OrderHistory;
import model.Product;

public class CheckoutManagerTest {

    @Test
    public void testSuccessfulCheckout() {

        Product product = new Product(1, "Laptop", 1000, 10);

        boolean result = CheckoutManager.checkoutProduct(product, 3);

        assertTrue(result);
        assertEquals(7, product.getQuantity());
    }

    @Test
    public void testCheckoutWithInsufficientStock() {

        Product product = new Product(1, "Laptop", 1000, 2);

        boolean result = CheckoutManager.checkoutProduct(product, 5);

        assertFalse(result);
        assertEquals(2, product.getQuantity());
    }

    @Test
    public void testCheckoutWithNegativeQuantity() {

        Product product = new Product(1, "Laptop", 1000, 10);

        boolean result = CheckoutManager.checkoutProduct(product, -1);

        assertFalse(result);
    }

    @Test
    public void testCheckoutWithZeroQuantity() {

        Product product = new Product(1, "Laptop", 1000, 10);

        boolean result = CheckoutManager.checkoutProduct(product, 0);

        assertFalse(result);
    }

    @Test
    public void testCheckoutWithNullProduct() {

        boolean result = CheckoutManager.checkoutProduct(null, 1);

        assertFalse(result);
    }

    @Test
    public void testCheckoutWithHistory() {

        Product product = new Product(1, "Laptop", 1000, 10);
        OrderHistory history = new OrderHistory();

        boolean result = CheckoutManager.checkoutWithHistory(product, 2, history);

        assertTrue(result);
        assertEquals(8, product.getQuantity());
    }
}