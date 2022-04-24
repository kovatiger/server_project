package app.controller;

import app.dto.PopularFlightDto;
import app.entity.Flight;
import app.mapper.FlightMapper;
import app.service.flight_service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class UserTripsMainMenuController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightMapper flightMapper;

    @GetMapping("/findTrip")
    public ResponseEntity<List<PopularFlightDto>> getAllTrips() {
        List<Flight> flightList = flightService.findAllPopularFlights();
        List<PopularFlightDto> popularFlightDtoList = flightMapper.getPopularFlightDtoFromFlight(flightList);
        if (!popularFlightDtoList.isEmpty()) {
            return new ResponseEntity<>(popularFlightDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
