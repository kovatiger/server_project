package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripToFindTicketDto {
    private String way;
    private String date;
    private Integer place;
}
