package app.controller;

import app.dto.TripForAdminPanelDto;
import app.entity.Trip;
import app.mapper.TripMapper;
import app.service.trip_service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdminTravelsController {
    @Autowired
    private TripService tripService;
    @Autowired
    private TripMapper tripMapper;

    @GetMapping("/adminPanel/travels")
    public ResponseEntity<List<TripForAdminPanelDto>> getAllTravels() {
        List<Trip> trips = tripService.findAllTrips();
        List<TripForAdminPanelDto> tripList = tripMapper.getTripsForAdminPanelFromTrip(trips);
        if (!tripList.isEmpty()) {
            return new ResponseEntity<>(tripList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
