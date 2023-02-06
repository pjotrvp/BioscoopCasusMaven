package bioscoopCasus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class order {
    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<movieTicket> tickets;
    public boolean weekend = false;

    public order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        tickets = new ArrayList<>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(movieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        double price = 0;
        int amountOfTickets = tickets.size();
        String movieDay = tickets.get(0).movieScreening.getDateAndTime().getDayOfWeek().toString();

        if (movieDay == "FRIDAY" || movieDay == "SATURDAY" || movieDay == "SUNDAY") {
            weekend = true;
        }

        if (isStudentOrder || (!isStudentOrder && !weekend)) {
            for (int i = 0; i < amountOfTickets; i++) {
                if (i % 2 == 0) {
                    price += tickets.get(i).getPrice();
                } else {
                    tickets.get(i).setFree();
                }
            }
        } else {
            for (movieTicket movieTicket : tickets) {
                price += movieTicket.getPrice();
            }
        }

        for (movieTicket movieTicket : tickets) {
            if (isStudentOrder && movieTicket.isPremiumTicket() && !movieTicket.isFree()) {
                price += 2;
            } else if (!isStudentOrder && movieTicket.isPremiumTicket() && !movieTicket.isFree()) {
                price += 3;
            }
        }

        if (amountOfTickets > 5 && weekend && !isStudentOrder) {
            price *= 0.9;
        }
        return price;
    }

    public void export(ticketExportFormat format) throws IOException {
        switch (format) {
            case PLAINTEXT:
                exportAsPlaintext();
                break;
            case JSON:
                exportAsJson();
                break;
        }
    }

    private void exportAsPlaintext() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ticketExports/orderReceipt.txt"))) {
            for (movieTicket ticket : tickets) {
                writer.write(ticket.toString());
                writer.newLine();
            }
            writer.write("Surcharge for premium tickets: 3 euro");
            writer.newLine();
            writer.write("Surcharge for student tickets: 2 euro");
            writer.newLine();
            writer.write("Total price: " + calculatePrice() + " euro");
        }
    }

    private void exportAsJson() throws IOException {
        try (JsonGenerator generator = new JsonFactory().createGenerator(
                new File("ticketExports/orderReceipt.json"), JsonEncoding.UTF8)) {
            generator.writeStartArray();
            for (movieTicket ticket : tickets) {
                generator.writeStartObject();
                generator.writeNumberField("rowNr", ticket.getRowNr());
                generator.writeNumberField("seatNr", ticket.getSeatNr());
                generator.writeBooleanField("isPremium", ticket.isPremiumTicket());
                generator.writeNumberField("price", ticket.getPrice());
                generator.writeEndObject();
            }
            generator.writeEndArray();
        }
    }
}