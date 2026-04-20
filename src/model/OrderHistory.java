package model;
import java.time.LocalDateTime;
import java.util.*;

public class OrderHistory {
    private Map<LocalDateTime, List<OrderItem>> orders = new HashMap<>();

    public void addOrder(LocalDateTime ldt, List<OrderItem> items){
        orders.put(ldt, items);
    }

    public void displayOrders(){
        System.out.println(orders);
    }
    
}
