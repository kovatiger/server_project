package app.service.user_service;

import app.entity.Role;
import app.entity.Status;
import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public void saveUser(User user, Role role, Status status) {
        user.setRole(role);
        user.setStatus(status);
        userRepository.save(user);
    }

    @Override
    public List<User> gelAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void changeUserStatusByLogin(Status userStatus, String login) {
        userRepository.updateUserStatusByLogin(userStatus, login);
    }

    @Override
    public void updateUserInfoByLogin(String oldLogin,User user) {
        User user1 = userRepository.findUserByLogin(oldLogin);
        user1.getUserInfoId().setMobileNumber(user.getUserInfoId().getMobileNumber());
        userRepository.updateUserByLogin(user.getLogin(), user.getPassword(), user1.getUserInfoId(),oldLogin);
    }
}
