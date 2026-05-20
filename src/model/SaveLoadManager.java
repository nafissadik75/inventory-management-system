package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveLoadManager {

    /**
     * Saves all products into a CSV file.
     * Format:
     * id,name,price,quantity
     */
    public static boolean saveProducts(ArrayList<Product> products, String filePath) {

        // Error handling
        if (products == null) {
            System.out.println("Error: Product list cannot be null.");
            return false;
        }

        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be empty.");
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Product product : products) {

                if (product == null) {
                    continue;
                }

                String line = product.getId() + ","
                        + product.getName() + ","
                        + product.getPrice() + ","
                        + product.getQuantity();

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Products saved successfully.");
            return true;

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads products from a CSV file.
     */
    public static ArrayList<Product> loadProducts(String filePath) {

        ArrayList<Product> loadedProducts = new ArrayList<>();

        // Error handling
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be empty.");
            return loadedProducts;
        }

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Error: File does not exist.");
            return loadedProducts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Edge case: invalid file format
                if (data.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    int quantity = Integer.parseInt(data[3]);

                    // Edge case: negative values
                    if (price < 0 || quantity < 0) {
                        System.out.println("Skipping invalid product values: " + line);
                        continue;
                    }

                    Product product = new Product(id, name, price, quantity);
                    loadedProducts.add(product);

                } catch (NumberFormatException e) {
                    System.out.println("Skipping malformed data: " + line);
                }
            }

            System.out.println("Products loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }

        return loadedProducts;
    }
}