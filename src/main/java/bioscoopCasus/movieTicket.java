package bioscoopCasus;

public class movieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;
    private boolean isFree = false;
    movieScreening movieScreening;

    public movieTicket(movieScreening movieScreening, int rowNr, int seatNr, boolean isPremium) {
        this.movieScreening = movieScreening;
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.isPremium = isPremium;
    }

    public boolean isPremiumTicket() {
        return isPremium;
    }

    public double getPrice() {
        return movieScreening.getPricePerSeat();
    }

    public void setFree() {
        isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getRowNr() {
        return rowNr;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public String ToString() {
        return "toString";
    }

}
