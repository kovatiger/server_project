package app.controller;

import app.dto.TripToFindTicketDto;
import app.dto.TripToOrderDto;
import app.entity.Flight;
import app.entity.Trip;
import app.service.trip_service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class UserPanelFindTicketController {
    @Autowired
    private TripService tripService;

    @PostMapping("/userPanel/findTicket")
    public ResponseEntity<List<TripToOrderDto>> findAllTrips(@RequestBody TripToFindTicketDto trip) {
        List<Trip> flights = tripService.findAllTrips();
        List<TripToOrderDto> trips = null;
        if (!flights.isEmpty()) {
            trips = tripService.findAllTripsByUserRequest(trip, flights);
        }
        if (!trips.isEmpty()) {
            return new ResponseEntity<>(trips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
