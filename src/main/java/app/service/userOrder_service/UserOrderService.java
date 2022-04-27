package app.service.userOrder_service;

import app.entity.User;
import app.entity.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderService {
    void save(UserOrder userOrder);

    List<UserOrder> findUserOrdersByUser(User userToFind);
}
