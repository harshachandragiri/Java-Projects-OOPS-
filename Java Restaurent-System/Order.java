import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private Customer customer;
    private List<MenuItem> items;
    private double totalPrice;

    // Constructor
    public Order(int orderNumber, Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Add item to order
    public void addItem(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    // Getters
    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("\n--- Order Details ---");
        System.out.println("Order Number: " + orderNumber);
        customer.displayCustomerInfo();
        System.out.println("\nItems Ordered:");
        for (MenuItem item : items) {
            item.displayInfo();
        }
        System.out.println("Total Price: ₹" + String.format("%.2f", totalPrice));
        System.out.println("---------------------\n");
    }
}
