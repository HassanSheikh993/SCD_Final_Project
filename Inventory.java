package inventorymanagementsystem;
import java.util.Scanner;
class Inventory {
    private Product[] products;
    private int size;
    private static final int MAX_PRODUCTS = 100;

    public Inventory() {
        this.products = new Product[MAX_PRODUCTS];
        this.size = 0;
    }

    public void addProductToInventory(Product product) {
        if (size < MAX_PRODUCTS) {
            products[size] = product;
            size++;
        } else {
            throw new IllegalStateException("Cannot add product. Maximum product capacity reached.");
        }
    }

    public void recordIncomingShipment(String productName, int quantity) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(productName)) {
                products[i].setQuantity(products[i].getQuantity() + quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found!");
    }

    public void updateInventory(String productName, int quantitySold) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(productName)) {
                if (products[i].getQuantity() >= quantitySold) {
                    products[i].setQuantity(products[i].getQuantity() - quantitySold);
                    return;
                } else {
                    throw new IllegalArgumentException("Insufficient stock for product: " + productName);
                }
            }
        }
        throw new IllegalArgumentException("Product not found!");
    }

    public void generateLowStockAlerts(int threshold) {
        for (int i = 0; i < size; i++) {
            if (products[i].getQuantity() < threshold) {
                System.out.println("Low stock alert: " + products[i].getName());
            }
        }
    }

    // Additional methods for dashboard and tracking product movements can be added here

    // Getters
    public int getSize() {
        return size;
    }

    public Product getProduct(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        return products[index];
    }
}
