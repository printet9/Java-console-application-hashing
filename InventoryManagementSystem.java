import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) {
        HashMap<Integer, String> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product by ID");
            System.out.println("3. Update Product Details");
            System.out.println("4. Remove Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name and Quantity (e.g., Laptop 10): ");
                    String productDetails = scanner.nextLine();
                    inventory.put(productId, productDetails);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product ID to search: ");
                    productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (inventory.containsKey(productId)) {
                        System.out.println("Product Details: " + inventory.get(productId));
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to update: ");
                    productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (inventory.containsKey(productId)) {
                        System.out.print("Enter new details (Name and Quantity): ");
                        productDetails = scanner.nextLine();
                        inventory.put(productId, productDetails);
                        System.out.println("Product details updated successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (inventory.remove(productId) != null) {
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 5:
                    System.out.println("\nAll Products:");
                    if (inventory.isEmpty()) {
                        System.out.println("No products in inventory.");
                    } else {
                        for (Integer key : inventory.keySet()) {
                            System.out.println("ID: " + key + ", Details: " + inventory.get(key));
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting the Inventory Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}