package model;

import java.time.LocalDateTime;

public class OrderHistory {
    private Product product;
    private int quantity;
    private LocalDateTime timestamp;

    public OrderHistory(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.timestamp = LocalDateTime.now();
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("Order | %s | Qty: %d | Time: %s", product.getName(), quantity, timestamp);
    }
}
