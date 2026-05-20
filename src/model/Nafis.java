package model;

import java.util.Scanner;

public class Nafis {
    
    // FIRST FEATURE
    // Method to take input from user to add a product
    public static Product addProductMenu(){
        Scanner sc_obj = new Scanner(System.in);
        // take id
        System.out.println("============================================");

        System.out.print("Please Input ID: ");
        int id = sc_obj.nextInt();

        // take name
        System.out.print("Please input Name of the product: ");
        String name = sc_obj.next();

        // take price
        System.out.print("Please input Price of the product: ");
        double price = sc_obj.nextDouble();

        // take quantity
        System.out.print("Please input Quantity of the product: ");
        int qty = sc_obj.nextInt();

        Product new_p = new Product(id, name, price, qty);

        System.out.println("============================================");
        System.out.println("Product Created Successfully!");

        return new_p;
    }
    

}
