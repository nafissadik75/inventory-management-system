package menu;

import java.util.Scanner;
import model.Product;

public class MainMenu {

    static Scanner sc_obj = new Scanner(System.in);

    public static void startupMessages(){
        // introduction
        System.out.println("============================================");
        System.out.println("Welcome to Your Shop Inventory Manager!");
        System.out.println("You can type exit to close the application.");
 
    }

    public static int mainMenuOptions(){
        System.out.println("============================================"); 
        System.out.println("Please select an option...");
        System.out.println("============================================");
 
        System.out.println("[1] Add a product");
        System.out.println("[2] Save");
        System.out.println("[3] Load");
        System.out.println("[5] Order History");
        System.out.println("[0] Exit");
        System.out.print("Please Input a number: ");

        int usr_input = sc_obj.nextInt();
        // sc_obj.close();
        return usr_input; 
    }


    // Method to take input from user to add a product
    public static Product addProductMenu(){
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
