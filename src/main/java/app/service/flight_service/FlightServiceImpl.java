package app.service.flight_service;

import app.entity.Flight;
import app.entity.Time;
import app.entity.Way;
import app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> findAllPopularFlights() {
        return flightRepository.findAllPopularFlights();
    }

    @Override
    public Flight findFlight(Time time, Way way) {
        return flightRepository.findByTimeIdAndWayId(time, way);
    }

}
