package app.validation;

import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationValidation {
    @Autowired
    private UserService userService;

    public boolean checkLoginForExists(String login) {
        if (userService.findUserByLogin(login) == null) {
            return false;
        } else {
            return true;
        }
    }
}
