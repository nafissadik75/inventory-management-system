package model;

import java.util.ArrayList;
import java.util.List;

public class Rand {
    private String name;
    private int quantity;
    private int lowStockThreshold;

    public void Product(String name, int quantity, int lowStockThreshold) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Initial stock cannot be negative");
        }
        this.name = name;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowStockThreshold() {
        return lowStockThreshold;
    }
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }



    // --- List all products ---
    public void listProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("===== PRODUCT LIST =====");

        for (Product p : products) {
            System.out.println(
                    " |     Name: " + p.getName() +
                    " | Quantity: " + p.getQuantity() +
                    " |    Price: " + p.getPrice() + "$"
            );
        }
    }

    //  --- Update Product Quantity ---
    public void updateQuantity(int change) {
        int newQuantity = this.quantity + change;

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        this.quantity = newQuantity;
    }
    

}
