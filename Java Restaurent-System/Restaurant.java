import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<MenuItem> menu;
    private List<Order> orders;
    private int nextOrderNumber;

    // Constructor
    public Restaurant() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
        nextOrderNumber = 1;
        initializeMenu();
    }

    // Initialize menu with predefined items
    private void initializeMenu() {
        // Appetizers
        menu.add(new MenuItem("Fries", 80.00));
        menu.add(new MenuItem("Soup", 120.00));
        menu.add(new MenuItem("Salad", 150.00));
        menu.add(new MenuItem("Nachos", 100.00));

        // Main Courses
        menu.add(new MenuItem("Pizza", 250.00));
        menu.add(new MenuItem("Burger", 180.00));
        menu.add(new MenuItem("Pasta", 220.00));
        menu.add(new MenuItem("Steak", 350.00));
        menu.add(new MenuItem("Sushi", 300.00));
        menu.add(new MenuItem("Tacos", 200.00));
        menu.add(new MenuItem("Sandwich", 160.00));
        menu.add(new MenuItem("Salmon", 320.00));

        // Beverages
        menu.add(new MenuItem("Coffee", 60.00));
        menu.add(new MenuItem("Tea", 50.00));
        menu.add(new MenuItem("Soda", 40.00));
        menu.add(new MenuItem("Juice", 70.00));

        // Desserts
        menu.add(new MenuItem("Ice Cream", 90.00));
        menu.add(new MenuItem("Cake", 110.00));
        menu.add(new MenuItem("Pie", 130.00));
    }

    // Get the menu
    public List<MenuItem> getMenu() {
        return menu;
    }

    // Display the menu categorized
    public void displayMenu() {
        System.out.println("\n--- Restaurant Menu ---");

        System.out.println("\nAppetizers:");
        displayCategory(0, 3);

        System.out.println("\nMain Courses:");
        displayCategory(4, 11);

        System.out.println("\nBeverages:");
        displayCategory(12, 15);

        System.out.println("\nDesserts:");
        displayCategory(16, 18);
    }

    // Helper method to display a category of menu items
    private void displayCategory(int start, int end) {
        for (int i = start; i <= end && i < menu.size(); i++) {
            menu.get(i).displayInfo();
        }
    }

    // Place a new order
    public Order placeOrder(Customer customer) {
        Order order = new Order(nextOrderNumber++, customer);
        orders.add(order);
        return order;
    }

    // Find order by order number
    public Order findOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        System.out.println("Order not found.");
        return null;
    }

    // Display all orders
    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("\nNo orders have been placed yet.\n");
            return;
        }
        System.out.println("\n--- All Orders ---");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}
