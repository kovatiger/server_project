package app.service.userOrder_service;

import app.entity.User;
import app.entity.UserOrder;
import app.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public void save(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public List<UserOrder> findUserOrdersByUser(User userToFind) {
        return userOrderRepository.findByUserId(userToFind);
    }
}
