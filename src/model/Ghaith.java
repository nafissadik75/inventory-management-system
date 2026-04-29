package model;

import java.util.ArrayList;
import java.util.List;

public class Ghaith {
    private ArrayList<Product> products = new ArrayList<>();
    private int id;
    private String name;
    
    public boolean removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == productId) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }


    public List<Product> searchByName(String name) {
    List<Product> results = new ArrayList<>();

    if (name == null || name.trim().isEmpty()) {
        return results;
    }

    String search = name.toLowerCase();

    for (Product product : inventory) {
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
