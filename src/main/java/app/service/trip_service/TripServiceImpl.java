package app.service.trip_service;

import app.dto.TripToFindTicketDto;
import app.dto.TripToOrderDto;
import app.entity.Trip;
import app.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public List<TripToOrderDto> findAllTripsByUserRequest(TripToFindTicketDto userTrip, List<Trip> allTrips) {
        List<TripToOrderDto> trips = new ArrayList<>();
        for (Trip trip : allTrips) {
            if (trip.getDateOfTrip().equals(userTrip.getDate()) && trip.getPlace() >= userTrip.getPlace() &&
                    trip.getFlightId().getWayId().getWay().equals(userTrip.getWay())) {
                TripToOrderDto orderDto = new TripToOrderDto();
                orderDto.setWay(trip.getFlightId().getWayId().getWay());
                orderDto.setDate(trip.getDateOfTrip());
                orderDto.setTime(trip.getFlightId().getTimeId().getTime());
                orderDto.setPrice(trip.getFlightId().getPrice());
                trips.add(orderDto);
            }
        }
        return trips;
    }
}
