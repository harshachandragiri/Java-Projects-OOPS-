public class Ticket {
    private int ticketNumber;
    private String eventName;
    private double price;
    private Customer customer;

    // Constructor
    public Ticket(int ticketNumber, String eventName, double price, Customer customer) {
        this.ticketNumber = ticketNumber;
        this.eventName = eventName;
        this.price = price;
        this.customer = customer;
    }

    // Getters
    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Display ticket details
    public void displayTicketInfo() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Event Name: " + eventName);
        System.out.println("Price: $" + price);
        customer.displayCustomerInfo();
    }
}
