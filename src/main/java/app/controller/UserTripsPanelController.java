package app.controller;

import app.dto.UserOrderForUserMenuDto;
import app.entity.User;
import app.entity.UserOrder;
import app.mapper.UserOrderMapper;
import app.service.userOrder_service.UserOrderService;
import app.service.user_service.UserService;
import app.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class UserTripsPanelController {
    @Autowired
    private UserValidation userValidation;
    @Autowired
    private UserService userService;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private UserOrderMapper userOrderMapper;

    @PostMapping("/userPanel/trips")
    public ResponseEntity<List<UserOrderForUserMenuDto>> getAllUserTrips(@RequestBody User user) {
        if (userValidation.checkUserForExistByLogin(user.getLogin())) {
            User userToFind = userService.findUserByLogin(user.getLogin());
            List<UserOrder> userOrders = userOrderService.findUserOrdersByUser(userToFind);
            if (userOrders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<UserOrderForUserMenuDto> orderForUserMenuDto = userOrderMapper.getUserOrderForMenuFromUserOrder(userOrders);
            if (!orderForUserMenuDto.isEmpty()) {
                return new ResponseEntity<>(orderForUserMenuDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
