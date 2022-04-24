package app.mapper;

import app.dto.UserAuthorizationDto;
import app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAuthorizationMapper {
    public UserAuthorizationDto getUserAuthorizationDtoFromUser(User authorizeUser) {
        UserAuthorizationDto authorizationDto = new UserAuthorizationDto();
        authorizationDto.setLogin(authorizeUser.getLogin());
        authorizationDto.setRole(authorizeUser.getRole().getRoleName());
        authorizationDto.setStatus(authorizeUser.getStatus().getStatusName());
        return authorizationDto;
    }
}
