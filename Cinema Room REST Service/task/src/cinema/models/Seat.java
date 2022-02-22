package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

import java.util.HashMap;
import java.util.Map;

public class Seat {
    String token;
    Map<String, Integer> ticket = new HashMap<>();

    public Seat() {
    }

    public Seat(String token, int row, int column, int price) {
        this.token = token;
        this.ticket.put("row", row);
        this.ticket.put("column", column);
        this.ticket.put("price", price);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Integer> getTicket() {
        return ticket;
    }

    public void setTicket(Map<String, Integer> ticket) {
        this.ticket = ticket;
    }
}
