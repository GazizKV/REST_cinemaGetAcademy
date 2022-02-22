package cinema.storage;


//  author:  ValitovGaziz
//  date:    14.02.2022
//  project: Cinema Room REST Service

import cinema.models.Seat;
import cinema.models.SeatWithPrice;
import cinema.models.Theatre;
import cinema.models.TokenDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class Storage {

    public final Theatre theatre = new Theatre(9, 9);

    public Storage() {
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Optional<SeatWithPrice> getTicketByToken(TokenDTO tokenDTO) {

        Optional<SeatWithPrice> result = Optional.empty();

        for (SeatWithPrice nextSeat : theatre.getAllSeats()) {
            if (nextSeat.getToken().equals(tokenDTO.getToken())) {
                result = Optional.of(nextSeat);
                break;
            }
        }

        return result;
    }

    public void setNotPurchasedByToken(TokenDTO tokenDTO) {

        Iterator<SeatWithPrice> iterator = theatre.getAllSeats().iterator();

        while (iterator.hasNext()) {
            SeatWithPrice nextSeatWithPrice = iterator.next();

            if (nextSeatWithPrice.getToken().equals(tokenDTO)) {
                nextSeatWithPrice.setPurchased(false);
            }
        }

    }
}
