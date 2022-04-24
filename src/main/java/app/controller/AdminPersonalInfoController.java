package app.controller;

import app.dto.AdminInfoDto;
import app.dto.AdminUpdateInfoDto;
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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdminPersonalInfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminMapper userMapper;
    @Autowired
    private UserValidation userValidation;

    @PostMapping("/adminPanel/personalInformation")
    public ResponseEntity<AdminInfoDto> getAdminInfo(@RequestBody final User user) {
        if (userValidation.checkUserForExistByLogin(user.getLogin())) {
            AdminInfoDto adminInfoDto = userMapper.getAdminInfoDtoFromUser(userService.findUserByLogin(user.getLogin()));
            return new ResponseEntity<>(adminInfoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/adminPanel/updateAdminInfo")
    public HttpStatus updateAdminPersonalInfo(@RequestBody final AdminUpdateInfoDto admin) {
        if (userValidation.checkUserForExistByLogin(admin.getOldLogin())) {
            User user = userMapper.getUserFromAdminUpdateInfoDto(admin);
            userService.updateUserInfoByLogin(admin.getOldLogin(), user);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
