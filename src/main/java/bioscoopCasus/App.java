package bioscoopCasus;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        movie theMatrix = new movie("The Matrix");
        movieScreening theMatrixScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-16T18:30"), 7);
        movieTicket matrixTicket1 = new movieTicket(theMatrixScreening, 1, 1, false);
        movieTicket matrixTicket2 = new movieTicket(theMatrixScreening, 1, 2, true);
        order matrixOrder = new order(1, false);
        matrixOrder.addSeatReservation(matrixTicket1);
        matrixOrder.addSeatReservation(matrixTicket2);
        matrixOrder.calculatePrice();
        System.out.println("main invoked");
        try {
            matrixOrder.export(ticketExportFormat.PLAINTEXT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
