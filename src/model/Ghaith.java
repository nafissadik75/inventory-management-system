package model;

import java.util.ArrayList;
import java.util.List;

public class Ghaith {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> cart = new ArrayList<>(); 
    
    private int id;
    private String name;
    
    // Constructor to set up the object and use the variables
    public Ghaith(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Helper method so the test can add products to check
    public void addProductToSystem(Product p) {
        if (p != null) {
            this.products.add(p);
        }
    }

    public boolean removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Product> searchByName(String query) {
        List<Product> results = new ArrayList<>();
        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        String search = query.toLowerCase();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search)) {
                results.add(product);
            }
        }
        return results;
    }

    public boolean removeFromCart(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.remove(i);
                return true;
            }
        }
        return false;
    }
}