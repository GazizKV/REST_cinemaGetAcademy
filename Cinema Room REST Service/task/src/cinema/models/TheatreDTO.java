package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

import java.util.ArrayList;
import java.util.List;

public class TheatreDTO {

    int total_rows;
    int total_columns;

    List<SeatInfo> available_seats;


    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<SeatInfo> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<SeatInfo> available_seats) {
        this.available_seats = available_seats;
    }
}
