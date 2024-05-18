package inventorymanagementsystem;
import java.util.Scanner;
class Reporting {
    private Inventory inventory;

    public Reporting(Inventory inventory) {
        this.inventory = inventory;
    }

    public void generateInventoryReport() {
        System.out.println("Inventory Report:");
        for (int i = 0; i < inventory.getSize(); i++) {
            Product product = inventory.getProduct(i);
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }

    // Additional methods for generating sales trends, top-selling products, and stock turnover rates can be added here
}
