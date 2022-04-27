package app.service.trip_service;

import app.dto.TripToFindTicketDto;
import app.dto.TripToOrderDto;
import app.entity.Flight;
import app.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    List<Trip> findAllTrips();

    List<TripToOrderDto> findAllTripsByUserRequest(TripToFindTicketDto trip, List<Trip> trips);

    Trip findTrip(String date, Flight flight);

    void updateAmountOfPlaces(Integer place, Flight flight, String date);
}
