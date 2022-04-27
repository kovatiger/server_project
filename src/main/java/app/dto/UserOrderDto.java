package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOrderDto {
    private String login;
    private String way;
    private String time;
    private Long price;
    private String date;
    private Integer place;
}
