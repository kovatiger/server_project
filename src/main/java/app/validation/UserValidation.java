package app.validation;

import app.entity.User;
import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    @Autowired
    private UserService userService;

    public boolean checkUserForExistByLogin(String login) {
        User user = userService.findUserByLogin(login);
        return user != null;
    }
}
