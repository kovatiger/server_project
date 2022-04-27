package app.facade;

import app.dto.UserOrderDto;
import org.springframework.stereotype.Component;

@Component
public interface UserOrderFacade {
    void saveUserOrder(UserOrderDto userOrderDto);
}
