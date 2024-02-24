package com.ncuindia.Inventorymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleUI implements CommandLineRunner {

    private final InventoryService inventoryService;

    @Autowired
    public ConsoleUI(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);

        inventoryService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        Product existingProduct = inventoryService.getProductById(id);
        if (existingProduct == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            existingProduct.setName(name);
        }

        System.out.print("Enter new quantity (enter 0 to keep current): ");
        int quantity = scanner.nextInt();
        existingProduct.setQuantity(quantity);

        System.out.print("Enter new price (enter 0 to keep current): ");
        double price = scanner.nextDouble();
        existingProduct.setPrice(price);

        inventoryService.updateProduct(existingProduct);
        System.out.println("Product updated successfully!");
    }

    private void viewInventory() {
        System.out.println("Inventory:");
        for (Product product : inventoryService.getAllProducts()) {
            System.out.println(product);
        }
    }
}
