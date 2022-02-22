package cinema.controllers;

//  author:  ValitovGaziz
//  date:    14.02.2022
//  project: Cinema Room REST Service

import cinema.models.Seat;
import cinema.models.SeatDTO;
import cinema.models.TheatreDTO;
import cinema.models.TokenDTO;
import cinema.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
public class SeatsController {


    private final Service service;

    @Autowired
    public SeatsController(Service service) {
        this.service = service;
    }

    @GetMapping("/seats")
    public TheatreDTO getSeats() {
        return service.getTheatreInfo();
    }

    @PostMapping("/purchase")
    public ResponseEntity getPurchase(@RequestBody SeatDTO seatDTO) {

        if (seatDTO.getRow() < 1 || seatDTO.getRow() > 9 ||
                seatDTO.getColumn() < 1 || seatDTO.getColumn() > 9) {
            return new ResponseEntity(Map.of("error", "The number of a row or a column is out of bounds!"),
                    BAD_REQUEST);
        }

        boolean isPurchase = service.checkPurchase(seatDTO);

        if (isPurchase) {
            return new ResponseEntity(Map.of("error", "The ticket has been already purchased!"),
                    BAD_REQUEST);
        } else {
            return new ResponseEntity(service.getPrice(seatDTO), OK);
        }

    }

    @PostMapping("/return")
    public ResponseEntity returnTicket(@RequestBody TokenDTO tokenDTO) {
        Optional<Seat> seatOptional = service.getSeatByToken(tokenDTO);
        if (seatOptional.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Wrong token!"),
                    BAD_REQUEST);
        } else {
            return new ResponseEntity(Map.of("returned_ticket", seatOptional.get().getTicket()), OK);
        }
    }

    @PostMapping("/stats")
    public ResponseEntity getStats(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return new ResponseEntity(
                    new HashMap<String, Integer>() {{
                        put("current_income", service.getCurrentIncom());
                        put("number_of_available_seats", service.getAvailableSeats());
                        put("number_of_purchased_tickets", service.getPurchasedTicket());
                    }},
                    OK);

        } else {
            return new ResponseEntity(Map.of("error", "The password is wrong!"), UNAUTHORIZED);
        }
    }

}