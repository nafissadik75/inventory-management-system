import java.util.ArrayList;
import java.util.List;

public class AddToCart {

    private List<String> cartItems;
    private List<Double> cartPrices;

    public AddToCart() {
        cartItems = new ArrayList<>();
        cartPrices = new ArrayList<>();
    }

    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        cartItems.add(itemName);
        cartPrices.add(price);
    }

    public void removeItem(String itemName) {
        int index = cartItems.indexOf(itemName);
        if (index != -1) {
            cartItems.remove(index);
            cartPrices.remove(index);
        } else {
            throw new IllegalArgumentException("Item not found in cart");
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (double price : cartPrices) {
            total += price;
        }
        return total;
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public int getCartSize() {
        return cartItems.size();
    }

    public void clearCart() {
        cartItems.clear();
        cartPrices.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
