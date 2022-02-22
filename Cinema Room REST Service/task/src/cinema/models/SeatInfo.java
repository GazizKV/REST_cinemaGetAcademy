package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

public class SeatInfo {
    int row;
    int column;
    int price;

    public SeatInfo() {
    }

    public SeatInfo(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
