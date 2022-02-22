package cinema.services;

//  author:  ValitovGaziz
//  date:    14.02.2022
//  project: Cinema Room REST Service

import cinema.models.*;
import cinema.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Storage storage;

    @Autowired
    public Service(Storage storage) {
        this.storage = storage;
    }

    public TheatreDTO getTheatreInfo() {
        TheatreDTO theatreDTO = new TheatreDTO();
        theatreDTO.setTotal_rows(storage.getTheatre().getTotal_rows());
        theatreDTO.setTotal_columns(storage.getTheatre().getTotal_columns());
        List<SeatInfo> availableSeat = new ArrayList<>();
        for (SeatWithPrice nextSeat : storage.getTheatre().getAllSeats()) {
            if (!nextSeat.getPurchased()) {
                availableSeat.add(new SeatInfo(nextSeat.getRow(), nextSeat.getColumn(), nextSeat.getPrice()));
            }
        }
        theatreDTO.setAvailable_seats(availableSeat);
        return theatreDTO;
    }

    public boolean checkPurchase(SeatDTO seatDTO) {

        SeatWithPrice currentSeat = null;

        for (SeatWithPrice nextSeat : storage.getTheatre().getAllSeats()) {
            if (nextSeat.getRow() == seatDTO.getRow() && nextSeat.getColumn() == seatDTO.getColumn()) {
                currentSeat = nextSeat;
                break;
            }
        }

        return currentSeat.getPurchased();

    }

    public Seat getPrice(SeatDTO seat) {

        Seat result = null;

        for (SeatWithPrice nextSeat : storage.getTheatre().getAllSeats()) {
            if (nextSeat.getRow() == seat.getRow() && nextSeat.getColumn() == seat.getColumn()) {
                nextSeat.setPurchased(true);
                result = new Seat(nextSeat.getToken(), nextSeat.getRow(), nextSeat.getColumn(), nextSeat.getPrice());
            }
        }

        return result;
    }

    public Optional<Seat> getSeatByToken(TokenDTO tokenDTO) {
        Optional<SeatWithPrice> optionalSeat = storage.getTicketByToken(tokenDTO);
        Optional<Seat> result = Optional.empty();
        if (optionalSeat.isPresent()) {
            optionalSeat.get().setPurchased(false);
            SeatWithPrice current = optionalSeat.get();
            result = Optional.of(new Seat(current.getToken(), current.getRow(), current.getColumn(), current.getPrice()));
        }
        return result;
    }

    public Integer getCurrentIncom() {

        List<SeatWithPrice> allSeats = storage.getTheatre().getAllSeats();

        int sum = 0;

        for (SeatWithPrice nextSeat : allSeats) {
            if (nextSeat.getPurchased()) {
                sum = sum + nextSeat.getPrice();
            }
        }

        return sum;
    }

    public Integer getAvailableSeats() {

        Integer countOfAvailableSeats = 0;

        List<SeatWithPrice> allSeat = storage.getTheatre().getAllSeats();

        for (SeatWithPrice nextSeat : allSeat) {
            if (!nextSeat.getPurchased()) {
                countOfAvailableSeats++;
            }
        }

        return countOfAvailableSeats;
    }

    public Integer getPurchasedTicket() {

        Integer result = 0;

        List<SeatWithPrice> allSeats = storage.getTheatre().getAllSeats();

        for (SeatWithPrice nextSeat : allSeats) {
            if (nextSeat.getPurchased()) {
                result++;
            }
        }

        return result;
    }
}
