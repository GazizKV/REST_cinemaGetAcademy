package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

import java.util.UUID;

public class SeatWithPrice {
    String  token;
    Integer row;
    Integer column;
    Integer price;
    Boolean purchased;

    public SeatWithPrice() {
    }

    public SeatWithPrice(Integer row, Integer column, Integer price) {
        this.token = String.valueOf(UUID.randomUUID());
        this.row = row;
        this.column = column;
        this.price = price;
        purchased = false;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getPrice() {
        return price;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
