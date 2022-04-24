package app.controller;

import app.dto.UserRegistrationDto;
import app.entity.Role;
import app.entity.Status;
import app.enums.RoleEnum;
import app.enums.StatusEnum;
import app.mapper.UserRegistrationMapper;
import app.service.role_service.RoleService;
import app.service.status_service.StatusService;
import app.service.user_service.UserService;
import app.validation.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:8080")
@RestController
public class RegistrationController {
    private final UserService userService;
    private final RoleService roleService;
    private final StatusService statusService;
    private final RegistrationValidation registrationValidation;
    private final UserRegistrationMapper userMapper;

    @Autowired
    public RegistrationController(UserService userService,
                                  RoleService roleService,
                                  StatusService statusService,
                                  RegistrationValidation registrationValidation,
                                  UserRegistrationMapper userMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.statusService = statusService;
        this.registrationValidation = registrationValidation;
        this.userMapper = userMapper;
    }

    @PostMapping("/registration")
    public HttpStatus registrationUser(@RequestBody final UserRegistrationDto userDto) {
        if (registrationValidation.checkLoginForExists(userDto.getLogin())) {
            return HttpStatus.BAD_REQUEST;
        } else {
            Role role = roleService.findRoleByRoleNameAndSaveIfDoesntExists(RoleEnum.USER.name());
            Status status = statusService.findStatusByStatusNameAndSaveIfDoesntExists(StatusEnum.ACTIVE.name());
            userService.saveUser(userMapper.getUserFromUserDto(userDto), role, status);
            return HttpStatus.OK;
        }
    }
}