package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket ticket1 = new Ticket(1, 1000, "DME", "LHR", 430);
    Ticket ticket2 = new Ticket(2, 20200, "DTL", "PEL", 520);
    Ticket ticket3 = new Ticket(3, 44000, "DME", "DXB", 630);
    Ticket ticket4 = new Ticket(4, 3000, "HND", "ICL", 120);
    Ticket ticket5 = new Ticket(5, 7000, "HKG", "PVG", 210);
    Ticket ticket6 = new Ticket(6, 9000, "DME", "AMS", 350);
    Ticket ticket7 = new Ticket(7, 11000, "DEN", "KUL", 400);
    Ticket ticket8 = new Ticket(8, 10600, "CTU", "LAS", 510);
    Ticket ticket9 = new Ticket(9, 13000, "BCN", "BOM", 490);
    Ticket ticket10 = new Ticket(10, 13000, "YYZ", "HND", 580);

    TicketRepository ticket = new TicketRepository();
    TicketManager manager = new TicketManager(ticket);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void shouldRepositorySave() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = ticket.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRepositoryRemoveById() {
        ticket.removeById(ticket4.getId());
        ticket.removeById(ticket5.getId());
        ticket.removeById(ticket9.getId());
        ticket.removeById(ticket10.getId());

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket6, ticket7, ticket8};
        Ticket[] actual = ticket.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy1() {
        String from = "DME";
        String to = "LHR";

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy2() {
        String from = "NUN";
        String to = "LHR";

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy3() {
        String from = "DME";
        String to = "NUN";

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy4InAscendingOrder() {
        String from = "D";
        String to = "L";

        Ticket[] expected = {ticket1, ticket4, ticket7, ticket2};
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy5() {
        String from = " ";
        String to = "LHR";

        Ticket[] expected = { };
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy6() {
        String from = "DME";
        String to = " ";

        Ticket[] expected = { };
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManagerSearchBy7InAscendingOrder() {
        String from = "";
        String to = "";

        Ticket[] expected = {ticket1, ticket4, ticket5, ticket6, ticket8, ticket7, ticket9, ticket10, ticket2, ticket3};
        Ticket[] actual = manager.searchBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }
}
