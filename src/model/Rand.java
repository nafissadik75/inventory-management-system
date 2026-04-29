package model;

import java.util.ArrayList;
import java.util.List;

public class Rand {
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
}
