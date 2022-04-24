package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TripForAdminPanelDto {
    private String fromCity;
    private String toCity;
    private String date;
    private String time;
}
