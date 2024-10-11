public class MenuItem {
    private String name;
    private double price;

    // Constructor
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Display menu item info
    public void displayInfo() {
        System.out.println(name + " - ₹" + String.format("%.2f", price));
    }
}
