package model;

public class Product {

    // All product will have id, name, price and quantity
    // All of them are private variables, meaning you cannot modify them directly
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor method
    public Product(int id, String name, double price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Getter methods (since we made our variables private, we will only call these methods to access them)
    public int getId(){return id;}
    public String getName() { return name;}
    public double getPrice() {return price;}
    public int getQuantity() {return quantity;}

    //Setters methods (since we made our variables private, we will only call these methods to modify them)
    public void setPrice(double price) {this.price = price;}
    public void setQuantity(int qty) {this.quantity = qty;}

    @Override //This annotator overrides the built-in method below it, providing us to make custom built-in method
    public String toString(){ //This method can be called just by directly using System.out.println(Product)
        return String.format("[%d] %s | Price: %.2f | Qty %d", id, name, price, quantity);
    }


}
