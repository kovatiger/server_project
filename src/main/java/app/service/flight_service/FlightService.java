package app.service.flight_service;

import app.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    List<Flight> findAllPopularFlights();
}
