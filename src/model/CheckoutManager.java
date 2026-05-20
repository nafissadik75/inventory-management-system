package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckoutManager {

    /**
     * Processes checkout for a single product.
     */
    public static boolean checkoutProduct(Product product, int quantityToBuy) {

        // Error handling
        if (product == null) {
            System.out.println("Error: Product cannot be null.");
            return false;
        }

        if (quantityToBuy <= 0) {
            System.out.println("Error: Quantity must be greater than 0.");
            return false;
        }

        int currentStock = product.getQuantity();

        // Edge case: insufficient stock
        if (quantityToBuy > currentStock) {
            System.out.println("Error: Not enough stock available.");
            return false;
        }

        product.setQuantity(currentStock - quantityToBuy);

        System.out.println("Checkout successful.");
        return true;
    }

    /**
     * Processes checkout and stores order history.
     */
    public static boolean checkoutWithHistory(
            Product product,
            int quantityToBuy,
            OrderHistory history) {

        // Error handling
        if (history == null) {
            System.out.println("Error: Order history cannot be null.");
            return false;
        }

        boolean success = checkoutProduct(product, quantityToBuy);

        if (!success) {
            return false;
        }

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(product, quantityToBuy));

        history.addOrder(LocalDateTime.now(), items);

        return true;
    }
}