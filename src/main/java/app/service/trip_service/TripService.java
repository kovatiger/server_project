package app.service.trip_service;

import app.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    List<Trip> findAllTrips();
}
