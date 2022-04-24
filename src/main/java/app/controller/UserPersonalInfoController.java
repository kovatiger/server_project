package app.controller;

import app.dto.UserUpdateInfoDto;
import app.dto.UserPersonalInfoDto;
import app.entity.User;
import app.mapper.AdminMapper;
import app.service.user_service.UserService;
import app.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:8080")
@RestController
public class UserPersonalInfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserValidation userValidation;

    @PostMapping("/userPanel/personalInformation")
    public ResponseEntity<UserPersonalInfoDto> getUserPersonalInfo(@RequestBody final User user) {
        if (userValidation.checkUserForExistByLogin(user.getLogin())) {
            UserPersonalInfoDto userPersonalInfoDto = adminMapper.getAdminInfoDtoFromUser(userService.findUserByLogin(user.getLogin()));
            return new ResponseEntity<>(userPersonalInfoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/userPanel/updateUserInfo")
    public HttpStatus updateUserPersonalInfo(@RequestBody final UserUpdateInfoDto user) {
        if (userValidation.checkUserForExistByLogin(user.getOldLogin())) {
            User newUser = adminMapper.getUserFromAdminUpdateInfoDto(user);
            userService.updateUserInfoByLogin(user.getOldLogin(), newUser);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
