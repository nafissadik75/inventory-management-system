package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AddToCartTest {

    private AddToCart cart;

    @BeforeEach
    void setUp() {
        cart = new AddToCart();
    }

    // ─────────────────────────────────────────
    // Input-Output Test Cases
    // ─────────────────────────────────────────

    @Test
    void TC1_addSingleItem_cartSizeIsOne() {
        cart.addItem("Apple", 1.99);
        assertEquals(1, cart.getCartSize());
        assertTrue(cart.getCartItems().contains("Apple"));
    }

    @Test
    void TC2_addMultipleItems_cartSizeIsCorrect() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Banana", 0.99);
        cart.addItem("Orange", 2.49);
        assertEquals(3, cart.getCartSize());
    }

    @Test
    void TC3_removeItem_itemNoLongerInCart() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Banana", 0.99);
        cart.removeItem("Apple");
        assertEquals(1, cart.getCartSize());
        assertFalse(cart.getCartItems().contains("Apple"));
    }

    @Test
    void TC4_getTotalPrice_returnsCorrectSum() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Banana", 0.99);
        assertEquals(2.98, cart.getTotalPrice(), 0.001);
    }

    @Test
    void TC5_clearCart_cartIsEmpty() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Banana", 0.99);
        cart.clearCart();
        assertEquals(0, cart.getCartSize());
        assertTrue(cart.isEmpty());
    }

    // ─────────────────────────────────────────
    // Edge Cases
    // ─────────────────────────────────────────

    @Test
    void EC1_newCart_isEmptyNotNull() {
        assertNotNull(cart.getCartItems());
        assertTrue(cart.isEmpty());
    }

    @Test
    void EC2_totalPriceOnEmptyCart_returnsZero() {
        assertEquals(0.0, cart.getTotalPrice(), 0.001);
    }

    @Test
    void EC3_addItemThenRemove_cartIsEmpty() {
        cart.addItem("Apple", 1.99);
        cart.removeItem("Apple");
        assertTrue(cart.isEmpty());
    }

    @Test
    void EC4_addSameItemTwice_cartSizeIsTwo() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Apple", 1.99);
        assertEquals(2, cart.getCartSize());
    }

    @Test
    void EC5_addItemWithZeroPrice_addedSuccessfully() {
        cart.addItem("FreeItem", 0.0);
        assertEquals(1, cart.getCartSize());
        assertEquals(0.0, cart.getTotalPrice(), 0.001);
    }

    // ─────────────────────────────────────────
    // Error Handling Tests
    // ─────────────────────────────────────────

    @Test
    void EH1_addItemWithNullName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(null, 1.99);
        });
    }

    @Test
    void EH2_addItemWithEmptyName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("", 1.99);
        });
    }

    @Test
    void EH3_addItemWithNegativePrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Apple", -1.0);
        });
    }

    @Test
    void EH4_removeNonExistentItem_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("NonExistent");
        });
    }

    @Test
    void EH5_mutatingReturnedList_doesNotAffectInternalCart() {
        cart.addItem("Apple", 1.99);
        List<String> items = cart.getCartItems();
        items.clear();
        assertEquals(1, cart.getCartSize());
    }
}
