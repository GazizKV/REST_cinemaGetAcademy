package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    int total_rows;
    int total_columns;

    List<SeatWithPrice> allSeats = new ArrayList<>();

    public Theatre(Integer total_rows, Integer total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                if (i <= 4) {
                    allSeats.add(new SeatWithPrice(i, j, 10));
                } else {
                    allSeats.add(new SeatWithPrice(i, j, 8));
                }
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }


    public List<SeatWithPrice> getAllSeats() {
        return allSeats;
    }

}
