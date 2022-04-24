package app.service.trip_service;

import app.entity.Trip;
import app.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }
}
