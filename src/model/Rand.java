package model;

import java.util.ArrayList;

public class Rand {
    private ArrayList<Product> products = new ArrayList<>();
    private int id;
    private String name;

    public Rand(int id, String name){
        this.name = name;
        this.id = id;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public ArrayList<Product> getProducts() {return products;}

    public void addProduct(Product p){
        products.add(p);                //code to add product in the inventory here

    }
}
