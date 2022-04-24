package app.validation;

import app.entity.User;
import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginValidation {
    @Autowired
    private UserService userService;

    public boolean checkExistsOfUser(User user) {
        User userForCheckingLogin = userService.findUserByLogin(user.getLogin());
        boolean checkRightOfPassword = false;
        if (userForCheckingLogin != null) {
            checkRightOfPassword = userForCheckingLogin.getPassword().equals(user.getPassword());
        }
        return checkRightOfPassword;
    }
}
