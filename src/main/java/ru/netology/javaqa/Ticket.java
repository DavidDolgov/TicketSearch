package ru.netology.javaqa;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int time;

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int time) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
