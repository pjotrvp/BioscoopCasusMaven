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
    movieTicket matrixTicketMonday1 = new movieTicket(MondayScreening, 1, 1, false);
    movieTicket matrixTicketMonday2 = new movieTicket(MondayScreening, 1, 2, false);
    movieTicket matrixTicketMonday3 = new movieTicket(MondayScreening, 1, 3, false);
    movieTicket matrixTicketTuesday = new movieTicket(TuesdayScreening, 1, 1, false);
    movieTicket matrixTicketWednesday = new movieTicket(WednesdayScreening, 1, 1, false);
    movieTicket matrixTicketThursday = new movieTicket(ThursdayScreening, 1, 1, false);
    movieTicket matrixTicketFriday = new movieTicket(FridayScreening, 1, 1, true);
    movieTicket matrixTicketSaturday = new movieTicket(SaturdayScreening, 1, 1, false);
    movieTicket matrixTicketSunday1 = new movieTicket(SundayScreening, 1, 1, false);
    movieTicket matrixTicketSunday2 = new movieTicket(SundayScreening, 1, 2, false);
    movieTicket matrixTicketSunday3 = new movieTicket(SundayScreening, 1, 3, false);
    order studentOrder = new order(1, true);
    order regularOrder = new order(2, false);

    // Tests for checking the date
    @Test
    public void MovieDateShouldBeMonday() {
        String Screening = MondayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("MONDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketMonday1);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(false, weekend);
    }

    @Test
    public void MovieDateShouldBeTuesday() {
        String Screening = TuesdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("TUESDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketTuesday);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(false, weekend);
    }

    @Test
    public void MovieDateShouldBeWednesday() {
        String Screening = WednesdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("WEDNESDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketWednesday);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(false, weekend);
    }

    @Test
    public void MovieDateShouldBeThursday() {
        String Screening = ThursdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("THURSDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketThursday);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(false, weekend);
    }

    @Test
    public void MovieDateShouldBeFriday() {
        String Screening = FridayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("FRIDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketFriday);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(true, weekend);
    }

    @Test
    public void MovieDateShouldBeSaturday() {
        String Screening = SaturdayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("SATURDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketSaturday);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(true, weekend);
    }

    @Test
    public void MovieDateShouldBeSunday() {
        String Screening = SundayScreening.getDateAndTime().getDayOfWeek().toString();
        assertEquals("SUNDAY", Screening);
        studentOrder.addSeatReservation(matrixTicketSunday1);
        studentOrder.calculatePrice();
        boolean weekend = studentOrder.weekend;
        assertEquals(true, weekend);
    }

    // Tests for checking the price without premium seats
    @Test
    public void OneFourEuroStudentTicketShouldCostFourEuro() {
        studentOrder.addSeatReservation(matrixTicketMonday1);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroStudentTicketsShouldCostFourEuro() {
        studentOrder.addSeatReservation(matrixTicketSunday1);
        studentOrder.addSeatReservation(matrixTicketSunday2);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void ThreeFourEuroStudentTicketsShouldCostEightEuro() {
        studentOrder.addSeatReservation(matrixTicketSunday1);
        studentOrder.addSeatReservation(matrixTicketSunday2);
        studentOrder.addSeatReservation(matrixTicketSunday3);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(8.0, totalprice, 0.0);
    }

    @Test
    public void OneFourEuroRegularTicketShouldCostFourEuro() {
        regularOrder.addSeatReservation(matrixTicketMonday1);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroRegularTicketsInTheWeekendShouldCostEightEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(8.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroRegularTicketsOutsideTheWeekendShouldCostFourEuro() {
        regularOrder.addSeatReservation(matrixTicketMonday1);
        regularOrder.addSeatReservation(matrixTicketMonday2);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void ThreeFourEuroRegularTicketsInTheWeekendShouldCostTwelveEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(12.0, totalprice, 0.0);
    }

    @Test
    public void ThreeFourEuroRegularTicketsOutsideTheWeekendShouldCostEightEuro() {
        regularOrder.addSeatReservation(matrixTicketMonday1);
        regularOrder.addSeatReservation(matrixTicketMonday2);
        regularOrder.addSeatReservation(matrixTicketMonday3);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(8.0, totalprice, 0.0);
    }

    @Test
    public void FiveFourEuroRegularTicketsInTheWeekendShouldCostTwentyEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(20.0, totalprice, 0.0);
    }

    @Test
    // 6 regular tickets
    public void SixFourEuroRegularTicketsInTheWeekendShouldCostTwentyOnePointSixEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(21.6, totalprice, 0.0);
    }

    @Test
    // 6 regular tickets outside the weekend
    public void SixFourEuroRegularTicketsOutsideTheWeekendShouldCostTwelveEuro() {
        regularOrder.addSeatReservation(matrixTicketMonday1);
        regularOrder.addSeatReservation(matrixTicketMonday2);
        regularOrder.addSeatReservation(matrixTicketMonday3);
        regularOrder.addSeatReservation(matrixTicketMonday1);
        regularOrder.addSeatReservation(matrixTicketMonday2);
        regularOrder.addSeatReservation(matrixTicketMonday3);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(12.0, totalprice, 0.0);
    }

    // Tests for checking the price with premium seats
    @Test
    public void SixFourEuroRegularTicketsInTheWeekendWithOnePremiumSeatShouldCostTwentyFourPointThreeEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketFriday);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(24.3, totalprice, 0.0);
    }

    @Test
    public void FiveFourEuroRegularTicketsInTheWeekendWithOnePremiumSeatShouldCostTwentyThreeEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketSunday2);
        regularOrder.addSeatReservation(matrixTicketSunday3);
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketFriday);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(23.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroRegularTicketsWithOnePremiumSeatInTheWeekendShouldCostElevenEuro() {
        regularOrder.addSeatReservation(matrixTicketSunday1);
        regularOrder.addSeatReservation(matrixTicketFriday);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(11.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroRegularTicketsWithOnePremiumSeatOutsideTheWeekendShouldCostFourEuro() {
        regularOrder.addSeatReservation(matrixTicketMonday1);
        regularOrder.addSeatReservation(matrixTicketThursday);
        double totalprice = regularOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void TwoFourEuroStudentTicketsWithOnePremiumSeatShouldCostFourEuro() {
        studentOrder.addSeatReservation(matrixTicketSunday1);
        studentOrder.addSeatReservation(matrixTicketFriday);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(4.0, totalprice, 0.0);
    }

    @Test
    public void OneFourEuroStudentTicketWithOnePremiumSeatShouldCostSixEuro() {
        studentOrder.addSeatReservation(matrixTicketFriday);
        double totalprice = studentOrder.calculatePrice();
        assertEquals(6.0, totalprice, 0.0);
    }
}
