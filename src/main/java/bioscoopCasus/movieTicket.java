package bioscoopCasus;

public class movieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;
    movieScreening movieScreening;
    public movieTicket(movieScreening movieScreening, int rowNr, int seatNr, boolean isPremium) {
        this.movieScreening = movieScreening;
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.isPremium = isPremium;
    }

    public boolean isPremiumTicket(){
        return isPremium;
    }

    public double getPrice(){
        return movieScreening.getPricePerSeat(); 
    }

    public int getRowNr(){
        return rowNr;
    }

    public int getSeatNr(){
        return seatNr;
    }
    
    public String ToString(){
        return "toString";
    }


    
}
