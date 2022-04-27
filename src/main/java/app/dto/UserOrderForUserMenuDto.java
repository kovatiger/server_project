package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOrderForUserMenuDto {
    private String way;
    private String date;
    private String time;
    private Long price;
}
