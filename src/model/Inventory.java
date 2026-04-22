package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();
    private int id;
    private String name;

    public Inventory(int id, String name){
        this.name = name;
        this.id = id;
    }

    public Inventory() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public ArrayList<Product> getProducts() {return products;}

    public void addProduct(Product p){
        products.add(p);                //code to add product in the inventory here

    }
    public boolean removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == productId) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    public static void saveInventory(String file_path){

    }

    public void removeProductById(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProductById'");
    }

    public List<Product> listProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listProducts'");
    }

    // public static Inventory loadInventory(String file_path){}

}
