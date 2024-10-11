// Show.java
public class Show {
    private int showId;
    private Movie movie;
    private String showTime;
    private int totalSeats;
    private int availableSeats;
    private double pricePerTicket;

    // Constructor
    public Show(int showId, Movie movie, String showTime, int totalSeats, double pricePerTicket) {
        this.showId = showId;
        this.movie = movie;
        this.showTime = showTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.pricePerTicket = pricePerTicket;
    }

    // Getters
    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPricePerTicket() {
        return pricePerTicket;
    }

    // Book seats
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        } else {
            return false;
        }
    }

    // Display show info
    public void displayShowInfo() {
        System.out.println("Show ID       : " + showId);
        movie.displayMovieInfo();
        System.out.println("Show Time     : " + showTime);
        System.out.println("Total Seats   : " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Price per Ticket: ₹" + String.format("%.2f", pricePerTicket));
    }
}
