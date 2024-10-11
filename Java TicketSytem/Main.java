import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Ticket Booking System");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Book a Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();

                    System.out.print("Enter Ticket Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Customer Phone Number: ");
                    String phone = scanner.nextLine();

                    Customer customer = new Customer(name, email, phone);
                    bookingSystem.bookTicket(eventName, price, customer);
                    break;

                case 2:
                    System.out.print("Enter Ticket Number: ");
                    int ticketNumber = Integer.parseInt(scanner.nextLine());
                    Ticket ticket = bookingSystem.findTicket(ticketNumber);
                    if (ticket != null) {
                        ticket.displayTicketInfo();
                    }
                    break;

                case 3:
                    bookingSystem.displayAllTickets();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Ticket Booking System.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
