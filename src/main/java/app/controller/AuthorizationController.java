package app.controller;

import app.dto.UserAuthorizationDto;
import app.entity.User;
import app.mapper.UserAuthorizationMapper;
import app.service.user_service.UserService;
import app.validation.LoginValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AuthorizationController {
    @Autowired
    private LoginValidation loginValidation;
    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthorizationMapper userMapper;

    @PostMapping("/authorization")
    public ResponseEntity<UserAuthorizationDto> authorization(@RequestBody final User user) {
        if (loginValidation.checkExistsOfUser(user)) {
            User authorizeUser = userService.findUserByLogin(user.getLogin());
            UserAuthorizationDto authorizationDto = userMapper.getUserAuthorizationDtoFromUser(authorizeUser);
            return new ResponseEntity<>(authorizationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
