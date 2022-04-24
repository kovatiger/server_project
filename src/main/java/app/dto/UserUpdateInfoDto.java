package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateInfoDto {
    private String oldLogin;
    private String login;
    private String mobileNumber;
    private String password;
}
