import java.util.List;
import java.util.ArrayList;

public class TicketBookingSystem {
    private List<Ticket> tickets;
    private int nextTicketNumber = 1;

    // Constructor
    public TicketBookingSystem() {
        tickets = new ArrayList<>();
    }

    // Book a new ticket
    public Ticket bookTicket(String eventName, double price, Customer customer) {
        Ticket newTicket = new Ticket(nextTicketNumber++, eventName, price, customer);
        tickets.add(newTicket);
        System.out.println("Ticket booked successfully! Ticket Number: " + newTicket.getTicketNumber());
        return newTicket;
    }

    // Find ticket by ticket number
    public Ticket findTicket(int ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                return ticket;
            }
        }
        System.out.println("Ticket not found.");
        return null;
    }

    // Display all tickets
    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            for (Ticket ticket : tickets) {
                ticket.displayTicketInfo();
                System.out.println("----------------------------");
            }
        }
    }
}
