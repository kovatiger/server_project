package app.mapper;

import app.dto.TripForAdminPanelDto;
import app.entity.Trip;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripMapper {
    public List<TripForAdminPanelDto> getTripsForAdminPanelFromTrip(List<Trip> trips) {
        List<TripForAdminPanelDto> tripList = new ArrayList<>();
        for (Trip trip : trips) {
            TripForAdminPanelDto tripForAdminPanelDto = new TripForAdminPanelDto();
            String[] cityArray = trip.getFlightId().getWayId().getWay().split("-");
            tripForAdminPanelDto.setFromCity(cityArray[0]);
            tripForAdminPanelDto.setToCity(cityArray[1]);
            tripForAdminPanelDto.setDate(trip.getDateOfTrip());
            tripForAdminPanelDto.setTime(trip.getFlightId().getTimeId().getTime());
            tripList.add(tripForAdminPanelDto);
        }
        return tripList;
    }
}
