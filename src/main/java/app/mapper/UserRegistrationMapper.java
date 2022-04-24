package app.mapper;

import app.dto.UserRegistrationDto;
import app.entity.User;
import app.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {
    public User getUserFromUserDto(UserRegistrationDto userDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setMobileNumber(userDto.getMobileNumber());
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setUserInfoId(userInfo);
        return user;
    }
}
