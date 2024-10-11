// MovieBookingSystem.java
import java.util.ArrayList;
import java.util.List;

public class MovieBookingSystem {
    private List<Movie> movies;
    private List<Show> shows;
    private List<Booking> bookings;
    private int nextShowId;
    private int nextBookingId;

    // Constructor
    public MovieBookingSystem() {
        movies = new ArrayList<>();
        shows = new ArrayList<>();
        bookings = new ArrayList<>();
        nextShowId = 1;
        nextBookingId = 1;
        initializeSystem();
    }

    // Initialize system with some movies and shows
    private void initializeSystem() {
        // Adding Movies
        Movie movie1 = new Movie("Dil Bechara", "Romance", 142);
        Movie movie2 = new Movie("Shershaah", "Action", 156);
        Movie movie3 = new Movie("Sooryavanshi", "Action", 159);
        Movie movie4 = new Movie("Kantara", "Thriller", 165);
        Movie movie5 = new Movie("Pushpa: The Rise", "Action", 183);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        // Adding Shows
        shows.add(new Show(nextShowId++, movie1, "10:00 AM", 100, 300.00));
        shows.add(new Show(nextShowId++, movie2, "1:00 PM", 100, 350.00));
        shows.add(new Show(nextShowId++, movie3, "4:00 PM", 100, 320.00));
        shows.add(new Show(nextShowId++, movie4, "7:00 PM", 100, 400.00));
        shows.add(new Show(nextShowId++, movie5, "10:00 PM", 100, 380.00));
    }

    // Getters
    public List<Movie> getMovies() {
        return movies;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    // Display all shows
    public void displayAllShows() {
        System.out.println("\n--- Available Shows ---");
        for (Show show : shows) {
            show.displayShowInfo();
            System.out.println("-----------------------");
        }
    }

    // Find show by show ID
    public Show findShowById(int showId) {
        for (Show show : shows) {
            if (show.getShowId() == showId) {
                return show;
            }
        }
        return null;
    }

    // Place a booking
    public Booking placeBooking(Customer customer, Show show, int numberOfSeats) {
        if (show.bookSeats(numberOfSeats)) {
            Booking booking = new Booking(nextBookingId++, customer, show, numberOfSeats);
            bookings.add(booking);
            return booking;
        } else {
            return null;
        }
    }

    // Find booking by booking ID
    public Booking findBookingById(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    // Display all bookings
    public void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings have been made yet.\n");
            return;
        }
        System.out.println("\n--- All Bookings ---");
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
        }
    }
}
