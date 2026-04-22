import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RaadTest {

    private Shop shop;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        shop = new Shop();
        product1 = new Product(1, "Apple", 1.99, 50);
        product2 = new Product(2, "Banana", 0.99, 30);
        product3 = new Product(3, "Orange", 2.49, 20);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);
    }

    // ─────────────────────────────────────────
    // Input-Output Test Cases
    // ─────────────────────────────────────────

    @Test
    void TC1_oneOrderPlaced_returnsListOfSizeOne() {
        shop.placeOrder(product1, 2);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(1, history.size());
        assertEquals(1, history.get(0).getProduct().getId());
        assertEquals(2, history.get(0).getQuantity());
    }

    @Test
    void TC2_threeOrdersPlaced_returnsListOfSizeThreeInOrder() {
        shop.placeOrder(product1, 1);
        shop.placeOrder(product2, 2);
        shop.placeOrder(product3, 3);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(3, history.size());
        assertEquals(1, history.get(0).getProduct().getId());
        assertEquals(2, history.get(1).getProduct().getId());
        assertEquals(3, history.get(2).getProduct().getId());
    }

    @Test
    void TC3_twoOrdersForSameProduct_bothPresentAsDistinctEntries() {
        shop.placeOrder(product2, 1);
        shop.placeOrder(product2, 3);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(2, history.size());
        assertEquals(1, history.get(0).getQuantity());
        assertEquals(3, history.get(1).getQuantity());
    }

    @Test
    void TC4_orderPlacedThenHistoryRetrievedThenAnotherOrder_secondCallHasOneMore() {
        shop.placeOrder(product1, 1);
        List<OrderHistory> firstCall = shop.getOrderHistory();
        shop.placeOrder(product2, 1);
        List<OrderHistory> secondCall = shop.getOrderHistory();
        assertEquals(firstCall.size() + 1, secondCall.size());
    }

    @Test
    void TC5_fiveOrdersForFiveProducts_allReturnedNoDuplicates() {
        Product p4 = new Product(4, "Mango", 3.99, 10);
        Product p5 = new Product(5, "Grape", 1.49, 25);
        shop.addProduct(p4);
        shop.addProduct(p5);
        shop.placeOrder(product1, 1);
        shop.placeOrder(product2, 1);
        shop.placeOrder(product3, 1);
        shop.placeOrder(p4, 1);
        shop.placeOrder(p5, 1);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(5, history.size());
    }

    // ─────────────────────────────────────────
    // Edge Cases
    // ─────────────────────────────────────────

    @Test
    void EC1_noOrdersPlaced_returnsEmptyListNotNull() {
        List<OrderHistory> history = shop.getOrderHistory();
        assertNotNull(history);
        assertEquals(0, history.size());
    }

    @Test
    void EC2_hundredOrdersPlaced_returnsAllInOrder() {
        for (int i = 0; i < 100; i++) {
            shop.placeOrder(product1, 1);
        }
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(100, history.size());
    }

    @Test
    void EC3_orderWithMinimumQty_includedCorrectly() {
        shop.placeOrder(product1, 1);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(1, history.size());
        assertEquals(1, history.get(0).getQuantity());
    }

    @Test
    void EC4_orderWithVeryLargeQty_storedAndReturnedWithoutOverflow() {
        shop.placeOrder(product1, Integer.MAX_VALUE);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(1, history.size());
        assertEquals(Integer.MAX_VALUE, history.get(0).getQuantity());
    }

    @Test
    void EC5_sameProductOrderedMultipleTimes_eachIsASeparateEntry() {
        shop.placeOrder(product1, 1);
        shop.placeOrder(product1, 2);
        shop.placeOrder(product1, 3);
        List<OrderHistory> history = shop.getOrderHistory();
        assertEquals(3, history.size());
    }

    // ─────────────────────────────────────────
    // Error Handling Tests
    // ─────────────────────────────────────────

    @Test
    void EH1_placeOrderWithNullProduct_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            shop.placeOrder(null, 1);
        });
    }

    @Test
    void EH2_placeOrderWithZeroQty_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            shop.placeOrder(product1, 0);
        });
    }

    @Test
    void EH3_placeOrderWithNegativeQty_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            shop.placeOrder(product1, -1);
        });
    }

    @Test
    void EH4_placeOrderForProductNotInInventory_throwsIllegalStateException() {
        Product unknown = new Product(99, "Unknown", 9.99, 10);
        assertThrows(IllegalStateException.class, () -> {
            shop.placeOrder(unknown, 1);
        });
    }

    @Test
    void EH5_mutatingReturnedList_doesNotAffectInternalHistory() {
        shop.placeOrder(product1, 1);
        List<OrderHistory> history = shop.getOrderHistory();
        history.clear();
        List<OrderHistory> historyAgain = shop.getOrderHistory();
        assertEquals(1, historyAgain.size());
    }
}
