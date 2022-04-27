package app.service.flight_service;

import app.entity.Flight;
import app.entity.Time;
import app.entity.Way;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    List<Flight> findAllPopularFlights();

    Flight findFlight(Time time, Way way);
}
