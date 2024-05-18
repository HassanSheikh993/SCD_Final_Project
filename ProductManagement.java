package inventorymanagementsystem;
import java.util.Scanner;
class ProductManagement {
    private Product[] products;
    private int size;
    private static final int MAX_PRODUCTS = 100;

    public ProductManagement() {
        this.products = new Product[MAX_PRODUCTS];
        this.size = 0;
    }

    public void addProduct(String name, String description, double price, int quantity) {
        if (size < MAX_PRODUCTS) {
            products[size] = new Product(name, description, price, quantity);
            size++;
        } else {
            throw new IllegalStateException("Cannot add product. Maximum product capacity reached.");
        }
    }

    public void updateProduct(String name, double price, int quantity) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found!");
    }

    public void removeProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                shiftProductsLeft(i);
                size--;
                return;
            }
        }
        throw new IllegalArgumentException("Product not found!");
    }

    private void shiftProductsLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            products[i] = products[i + 1];
        }
        products[size - 1] = null;
    }

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
