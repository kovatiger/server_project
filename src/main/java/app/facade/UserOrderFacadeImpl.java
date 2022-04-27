package app.facade;

import app.dto.UserOrderDto;
import app.entity.*;
import app.mapper.UserOrderMapper;
import app.service.flight_service.FlightService;
import app.service.time_sevice.TimeService;
import app.service.trip_service.TripService;
import app.service.userOrder_service.UserOrderService;
import app.service.user_service.UserService;
import app.service.way_service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOrderFacadeImpl implements UserOrderFacade {
    @Autowired
    private UserService userService;
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Autowired
    private TimeService timeService;
    @Autowired
    private WayService wayService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private TripService tripService;
    @Autowired
    private UserOrderService userOrderService;

    public void saveUserOrder(UserOrderDto userOrderDto){
        User user = userService.findUserByLogin(userOrderDto.getLogin());
        Time time = timeService.findTime(userOrderDto.getTime());
        Way way = wayService.findWay(userOrderDto.getWay());
        Flight flight = flightService.findFlight(time, way);
        Trip trip = tripService.findTrip(userOrderDto.getDate(), flight);
        UserOrder userOrder = userOrderMapper.getUserOrderFromUserOrderDto(userOrderDto, user, trip);
        tripService.updateAmountOfPlaces(trip.getPlace() - userOrderDto.getPlace(), flight, userOrderDto.getDate());
        userOrderService.save(userOrder);
    }
}
