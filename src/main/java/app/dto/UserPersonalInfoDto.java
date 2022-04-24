package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPersonalInfoDto {
    private String login;
    private String mobileNumber;
    private String password;
}
