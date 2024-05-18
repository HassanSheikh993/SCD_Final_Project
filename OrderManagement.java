package inventorymanagementsystem;
import java.util.Scanner;
class OrderManagement {
    private Inventory inventory;

    public OrderManagement(Inventory inventory) {
        this.inventory = inventory;
    }

    public void processOrder(Order order) {
        String productName = order.getProductName();
        int quantity = order.getQuantity();

        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getProduct(i).getName().equals(productName)) {
                if (inventory.getProduct(i).getQuantity() >= quantity) {
                    inventory.updateInventory(productName, quantity);
                    System.out.println("Order processed successfully: " + order.getProductName() + " (Quantity: " + order.getQuantity() + ")");
                    return;
                } else {
                    throw new IllegalArgumentException("Insufficient stock for product: " + productName);
                }
            }
        }
        throw new IllegalArgumentException("Product not found in inventory: " + productName);
    }
}
