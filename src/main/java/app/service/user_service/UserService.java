package app.service.user_service;

import app.entity.Role;
import app.entity.Status;
import app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findUserByLogin(String login);

    void saveUser(User user, Role role, Status status);

    List<User> gelAllUsers();

    void changeUserStatusByLogin(Status status,String login);

    void updateUserInfoByLogin(String oldLogin,User user);
}
