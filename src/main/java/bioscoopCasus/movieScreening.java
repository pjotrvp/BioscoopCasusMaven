package bioscoopCasus;

import java.time.LocalDateTime;

public class movieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;
    private movie movie;

    public movieScreening(movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
        this.movie = movie;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String toString() {
        return String.format("%s %s %s", movie, dateAndTime, pricePerSeat);
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}
