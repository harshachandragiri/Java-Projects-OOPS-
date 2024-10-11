// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieBookingSystem system = new MovieBookingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Movie Booking System!");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View All Shows");
            System.out.println("2. Book Tickets");
            System.out.println("3. View a Booking");
            System.out.println("4. View All Bookings");
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
                    system.displayAllShows();
                    break;

                case 2:
                    System.out.print("\nEnter Customer Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    Customer customer = new Customer(name, phone);

                    system.displayAllShows();
                    System.out.print("\nEnter Show ID to book tickets: ");
                    String showInput = scanner.nextLine();
                    int showId;
                    try {
                        showId = Integer.parseInt(showInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Show ID.");
                        break;
                    }

                    Show show = system.findShowById(showId);
                    if (show == null) {
                        System.out.println("Show not found.");
                        break;
                    }

                    System.out.print("Enter number of seats to book: ");
                    String seatsInput = scanner.nextLine();
                    int numberOfSeats;
                    try {
                        numberOfSeats = Integer.parseInt(seatsInput);
                        if (numberOfSeats <= 0) {
                            System.out.println("Number of seats must be greater than zero.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number of seats.");
                        break;
                    }

                    Booking booking = system.placeBooking(customer, show, numberOfSeats);
                    if (booking != null) {
                        System.out.println("\nBooking successful!");
                        booking.displayBookingDetails();
                    } else {
                        System.out.println("Booking failed. Not enough available seats.");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter Booking ID to view: ");
                    String bookingInput = scanner.nextLine();
                    int bookingId;
                    try {
                        bookingId = Integer.parseInt(bookingInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Booking ID.");
                        break;
                    }

                    Booking foundBooking = system.findBookingById(bookingId);
                    if (foundBooking != null) {
                        foundBooking.displayBookingDetails();
                    } else {
                        System.out.println("Booking not found.");
                    }
                    break;

                case 4:
                    system.displayAllBookings();
                    break;

                case 5:
                    exit = true;
                    System.out.println("\nThank you for using the Movie Booking System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please select a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
