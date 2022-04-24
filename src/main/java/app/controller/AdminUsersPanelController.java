package app.controller;

import app.dto.UserForAdminPanelDto;
import app.dto.UserStatusDto;
import app.entity.Status;
import app.entity.User;
import app.mapper.AdminMapper;
import app.service.status_service.StatusService;
import app.service.user_service.UserService;
import app.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdminUsersPanelController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidation userValidation;
    @Autowired
    private StatusService statusService;
    @Autowired
    private AdminMapper userMapper;

    @GetMapping("/adminPanel/users")
    public ResponseEntity<List<UserForAdminPanelDto>> showAllUsers() {
        List<User> userList = userService.gelAllUsers();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<UserForAdminPanelDto> userForAdminPanelDtoList = userMapper.getUserForAdminPanelFromUser(userList);
        if (!userForAdminPanelDtoList.isEmpty()) {
            return new ResponseEntity<>(userForAdminPanelDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adminPanel/users")
    public HttpStatus blockOrUnblockUser(@RequestBody final UserStatusDto userStatusDto) {
        if (userValidation.checkUserForExistByLogin(userStatusDto.getLogin())) {
            Status userStatus = statusService.findStatusByStatusNameAndSaveIfDoesntExists(userStatusDto.getStatus());
            userService.changeUserStatusByLogin(userStatus, userStatusDto.getLogin());
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}