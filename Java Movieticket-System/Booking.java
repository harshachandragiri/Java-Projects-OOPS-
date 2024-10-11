// Booking.java
public class Booking {
    private int bookingId;
    private Customer customer;
    private Show show;
    private int numberOfSeats;
    private double totalPrice;

    // Constructor
    public Booking(int bookingId, Customer customer, Show show, int numberOfSeats) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = show.getPricePerTicket() * numberOfSeats;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Booking ID: " + bookingId);
        customer.displayCustomerInfo();
        System.out.println("Movie Title: " + show.getMovie().getTitle());
        System.out.println("Show Time  : " + show.getShowTime());
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Total Price     : ₹" + String.format("%.2f", totalPrice));
        System.out.println("-----------------------\n");
    }
}
