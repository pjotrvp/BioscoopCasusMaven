package bioscoopCasus;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        movie theMatrix = new movie("The Matrix");
        movieScreening SundayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-15T18:30"), 4);
        movieScreening mondayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-16T18:30"), 4);
        movieTicket matrixTicket1 = new movieTicket(SundayScreening, 1, 1, false);
        movieTicket matrixTicket2 = new movieTicket(SundayScreening, 1, 2, false);
        movieTicket matrixTicket3 = new movieTicket(SundayScreening, 1, 3, false);
        movieTicket matrixTicket4 = new movieTicket(SundayScreening, 1, 4, false);
        movieTicket matrixTicket5 = new movieTicket(SundayScreening, 1, 5, false);

        movieTicket matrixMonday1 = new movieTicket(mondayScreening, 1, 1, false);
        movieTicket matrixMonday2 = new movieTicket(mondayScreening, 1, 2, true);
        order studentOrder = new order(1, false);
        studentOrder.addSeatReservation(matrixMonday1);
        studentOrder.addSeatReservation(matrixMonday2);
        studentOrder.calculatePrice();
        try {
            studentOrder.export(ticketExportFormat.JSON);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
