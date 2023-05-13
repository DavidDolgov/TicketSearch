package ru.netology.javaqa;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public boolean matchesA(Ticket ticket, String search) {
        return ticket.getDepartureAirport().contains(search);
    }

    public boolean matchesB(Ticket ticket, String search) {
        return ticket.getArrivalAirport().contains(search);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesA(ticket, from)) {
                if (matchesB(ticket, to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                    Arrays.sort(result);
                }
            }
        }
        return result;
    }
}
