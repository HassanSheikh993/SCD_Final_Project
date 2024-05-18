package inventorymanagementsystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize user management
        UserManagement userManagement = new UserManagement();
        
        // Initialize product management
        ProductManagement productManagement = new ProductManagement();
        
        // Initialize inventory
        Inventory inventory = new Inventory();
        
        // Initialize order management
        OrderManagement orderManagement = new OrderManagement(inventory);
        
        // Initialize reporting
        Reporting reporting = new Reporting(inventory);

        boolean running = true;
        while (running) {
            System.out.println("1. Create User");
            System.out.println("2. Add Product");
            System.out.println("3. Record Incoming Shipment");
            System.out.println("4. Process Order");
            System.out.println("5. Generate Inventory Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter role: ");
                        String role = scanner.nextLine();
                        userManagement.createUser(username, role);
                        break;
                    case 2:
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter product description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter product quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        productManagement.addProduct(productName, description, price, quantity);
                        inventory.addProductToInventory(new Product(productName, description, price, quantity));
                        break;
                    case 3:
                        System.out.print("Enter product name for incoming shipment: ");
                        productName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        inventory.recordIncomingShipment(productName, quantity);
                        break;
                    case 4:
                        System.out.print("Enter product name for order: ");
                        productName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        orderManagement.processOrder(new Order(productName, quantity));
                        break;
                    case 5:
                        reporting.generateInventoryReport();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}