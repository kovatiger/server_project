package app.controller;

import app.dto.UserOrderDto;
import app.facade.UserOrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:8080")
@RestController
public class UserOrderController {

    @Autowired
    private UserOrderFacade userOrderFacade;

    @PostMapping("/userPanel/order")
    public HttpStatus orderTheTicket(@RequestBody UserOrderDto userOrderDto) {
        userOrderFacade.saveUserOrder(userOrderDto);
        return HttpStatus.OK;
    }

}
