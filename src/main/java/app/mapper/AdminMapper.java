package app.mapper;

import app.dto.*;
import app.entity.User;
import app.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMapper {
    public List<UserForAdminPanelDto> getUserForAdminPanelFromUser(List<User> userList) {
        List<UserForAdminPanelDto> userForAdminPanelDtoList = new ArrayList<>();
        for (User user : userList) {
            UserForAdminPanelDto userForAdminPanelDto = new UserForAdminPanelDto();
            userForAdminPanelDto.setLogin(user.getLogin());
            userForAdminPanelDto.setMobileNumber(user.getUserInfoId().getMobileNumber());
            userForAdminPanelDto.setStatus(user.getStatus().getStatusName());
            userForAdminPanelDtoList.add(userForAdminPanelDto);
        }
        return userForAdminPanelDtoList;
    }

    public UserPersonalInfoDto getAdminInfoDtoFromUser(User user) {
        UserPersonalInfoDto adminInfoDto = new UserPersonalInfoDto();
        adminInfoDto.setLogin(user.getLogin());
        adminInfoDto.setMobileNumber(user.getUserInfoId().getMobileNumber());
        adminInfoDto.setPassword(user.getPassword());
        return adminInfoDto;
    }

    public User getUserFromAdminUpdateInfoDto(UserUpdateInfoDto admin) {
        User user = new User();
        user.setLogin(admin.getLogin());
        user.setPassword(admin.getPassword());
        UserInfo userInfo = new UserInfo();
        userInfo.setMobileNumber(admin.getMobileNumber());
        user.setUserInfoId(userInfo);
        return user;
    }
}