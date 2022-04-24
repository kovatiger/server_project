package app.mapper;

import app.dto.PopularFlightDto;
import app.entity.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper {
    public List<PopularFlightDto> getPopularFlightDtoFromFlight(List<Flight> flightList) {
        List<PopularFlightDto> popularFlightDtoList = new ArrayList<>();
        for (Flight flight : flightList) {
            PopularFlightDto popularFlightDto = new PopularFlightDto();
            popularFlightDto.setPrice(flight.getPrice());
            popularFlightDto.setWay(flight.getWayId().getWay());
            popularFlightDtoList.add(popularFlightDto);
        }
        return popularFlightDtoList;
    }
}
