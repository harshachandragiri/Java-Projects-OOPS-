// Movie.java
public class Movie {
    private String title;
    private String genre;
    private int duration; // in minutes

    // Constructor
    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    // Display movie info
    public void displayMovieInfo() {
        System.out.println("Title   : " + title);
        System.out.println("Genre   : " + genre);
        System.out.println("Duration: " + duration + " minutes");
    }
}
