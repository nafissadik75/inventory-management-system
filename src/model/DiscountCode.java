import java.util.HashMap;
import java.util.Map;

public class DiscountCode {

    private Map<String, Double> discountCodes;

    public DiscountCode() {
        discountCodes = new HashMap<>();
    }

    public void addDiscountCode(String code, double discountPercent) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be empty");
        }
        if (discountPercent <= 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        discountCodes.put(code, discountPercent);
    }

    public void removeDiscountCode(String code) {
        if (!discountCodes.containsKey(code)) {
            throw new IllegalArgumentException("Code not found");
        }
        discountCodes.remove(code);
    }

    public boolean isValidCode(String code) {
        return discountCodes.containsKey(code);
    }

    public double applyDiscount(String code, double totalPrice) {
        if (!isValidCode(code)) {
            throw new IllegalArgumentException("Invalid discount code");
        }
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }
        double discountPercent = discountCodes.get(code);
        double discountAmount = totalPrice * (discountPercent / 100);
        return totalPrice - discountAmount;
    }

    public double getDiscountPercent(String code) {
        if (!isValidCode(code)) {
            throw new IllegalArgumentException("Invalid discount code");
        }
        return discountCodes.get(code);
    }

    public int getTotalCodes() {
        return discountCodes.size();
    }
}
