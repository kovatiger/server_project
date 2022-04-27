package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForAdminPanelDto {
    private String login;
    private String mobileNumber;
    private String status;
}
