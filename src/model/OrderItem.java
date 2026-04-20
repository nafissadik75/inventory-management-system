package model;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int qty){
        this.product = product;
        this.quantity = qty;
    }

    public int getQuantity(){return this.quantity;}
    public Product getProduct(){return this.product;}
    
}
