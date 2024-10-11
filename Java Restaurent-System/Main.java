import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Restaurant Order Management System!");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View Menu");
            System.out.println("2. Place an Order");
            System.out.println("3. View an Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    restaurant.displayMenu();
                    break;

                case 2:
                    System.out.print("\nEnter Customer Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    Customer customer = new Customer(name, phone);
                    Order order = restaurant.placeOrder(customer);

                    boolean addingItems = true;
                    while (addingItems) {
                        restaurant.displayMenu();
                        System.out.print("\nEnter item name to add to the order (or type 'done' to finish): ");
                        String itemName = scanner.nextLine();

                        if (itemName.equalsIgnoreCase("done")) {
                            addingItems = false;
                            continue;
                        }

                        boolean found = false;
                        for (MenuItem item : restaurant.getMenu()) {
                            if (item.getName().equalsIgnoreCase(itemName)) {
                                order.addItem(item);
                                found = true;
                                System.out.println(itemName + " added to your order.");
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Item not found. Please try again.");
                        }
                    }

                    order.displayOrderDetails();
                    break;

                case 3:
                    System.out.print("\nEnter Order Number to view: ");
                    String orderInput = scanner.nextLine();
                    int orderNumber;
                    try {
                        orderNumber = Integer.parseInt(orderInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid order number. Please enter a valid number.");
                        break;
                    }

                    Order foundOrder = restaurant.findOrder(orderNumber);
                    if (foundOrder != null) {
                        foundOrder.displayOrderDetails();
                    }
                    break;

                case 4:
                    restaurant.displayAllOrders();
                    break;

                case 5:
                    exit = true;
                    System.out.println("\nThank you for using the Restaurant Order Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
