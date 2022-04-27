package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripForAdminPanelDto {
    private String fromCity;
    private String toCity;
    private String date;
    private String time;
}
