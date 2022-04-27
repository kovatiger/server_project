package app.mapper;

import app.dto.UserOrderDto;
import app.dto.UserOrderForUserMenuDto;
import app.entity.Trip;
import app.entity.User;
import app.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserOrderMapper {
    public UserOrder getUserOrderFromUserOrderDto(UserOrderDto userOrderDto, User user, Trip trip) {
        UserOrder userOrder = new UserOrder();
        userOrder.setUserId(user);
        userOrder.setPlace(userOrderDto.getPlace());
        userOrder.setTripId(trip);
        return userOrder;
    }

    public List<UserOrderForUserMenuDto> getUserOrderForMenuFromUserOrder(List<UserOrder> userOrders) {
        List<UserOrderForUserMenuDto> orderForUserMenuDto = new ArrayList<>();
        for (UserOrder userOrder : userOrders) {
            UserOrderForUserMenuDto forUserMenuDto = new UserOrderForUserMenuDto();
            forUserMenuDto.setWay(userOrder.getTripId().getFlightId().getWayId().getWay());
            forUserMenuDto.setDate(userOrder.getTripId().getDateOfTrip());
            forUserMenuDto.setPrice(userOrder.getTripId().getFlightId().getPrice());
            forUserMenuDto.setTime(userOrder.getTripId().getFlightId().getTimeId().getTime());
            orderForUserMenuDto.add(forUserMenuDto);
        }
        return orderForUserMenuDto;
    }
}
