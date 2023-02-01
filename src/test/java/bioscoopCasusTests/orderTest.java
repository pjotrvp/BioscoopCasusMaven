package bioscoopCasusTests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

import bioscoopCasus.movie;
import bioscoopCasus.movieScreening;
import bioscoopCasus.movieTicket;
import bioscoopCasus.order;

public class orderTest {
    movie theMatrix = new movie("The Matrix");
    movieScreening SundayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-15T18:30"), 4);
    movieTicket matrixTicket1 = new movieTicket(SundayScreening, 1, 1, false);
    movieTicket matrixTicket2 = new movieTicket(SundayScreening, 1, 2, false);
    order studentOrder = new order(1, false);
    order regularOrder = new order(2, false);

    @Test
    public void TwoFourEuroStudentTicketsShouldCostFourEuro() {
        studentOrder.addSeatReservation(matrixTicket1);
        studentOrder.addSeatReservation(matrixTicket2);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }
}
