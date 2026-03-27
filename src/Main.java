import java.util.ArrayList;
import model.Inventory;
import model.Product;
import menu.MainMenu;

public class Main {

    public static ArrayList<Inventory> inventories = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args){
        
        MainMenu.startupMessages();

        int usr_input = 1;

        // Main Loop
        while (usr_input != 0) {
            usr_input = MainMenu.mainMenuOptions();
            switch (usr_input) {
                case 0:
                    break;
                case 1:
                    products.add(MainMenu.addProductMenu());
            }
        }
        
        System.out.println("Closing application...");
    }
       
}