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
    movieScreening MondayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-16T18:30"), 4);
    movieScreening TuesdayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-17T18:30"), 4);
    movieScreening WednesdayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-18T18:30"), 4);
    movieScreening ThursdayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-19T18:30"), 4);
    movieScreening FridayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-20T18:30"), 4);
    movieScreening SaturdayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-21T18:30"), 4);
    movieScreening SundayScreening = new movieScreening(theMatrix, LocalDateTime.parse("2023-10-22T18:30"), 4);
    movieTicket matrixTicket1 = new movieTicket(SundayScreening, 1, 1, false);
    movieTicket matrixTicket2 = new movieTicket(SundayScreening, 1, 2, false);
    movieTicket matrixTicket3 = new movieTicket(SundayScreening, 1, 3, false);
    order studentOrder = new order(1, true);
    order regularOrder = new order(2, false);

    // Tests for checking the date
    @Test
    public void MovieDateShouldBeMonday() {
        String Screening = MondayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("MONDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeTuesday() {
        String Screening = TuesdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("TUESDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeWednesday() {
        String Screening = WednesdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("WEDNESDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeThursday() {
        String Screening = ThursdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("THURSDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeFriday() {
        String Screening = FridayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("FRIDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeSaturday() {
        String Screening = SaturdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("SATURDAY", Screening);
    }

    @Test
    public void MovieDateShouldBeSunday() {
        String Screening = SundayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("SUNDAY", Screening);
    }

    // Tests for checking the price
    @Test
    public void TwoFourEuroStudentTicketsShouldCostFourEuro() {
        studentOrder.addSeatReservation(matrixTicket1);
        studentOrder.addSeatReservation(matrixTicket2);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void ThreeFourEuroStudentTicketsShouldCostEightEuro() {
        studentOrder.addSeatReservation(matrixTicket1);
        studentOrder.addSeatReservation(matrixTicket2);
        studentOrder.addSeatReservation(matrixTicket3);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(8.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroRegularTicketsShouldCostEightEuro() {
        regularOrder.addSeatReservation(matrixTicket1);
        regularOrder.addSeatReservation(matrixTicket2);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(8.0, totalprice, 0.0);
    }
}
