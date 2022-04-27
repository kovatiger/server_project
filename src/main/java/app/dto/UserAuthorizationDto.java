package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthorizationDto {
    private String login;
    private String role;
    private String status;
}
