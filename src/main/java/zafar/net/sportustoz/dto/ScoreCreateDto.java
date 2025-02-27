package zafar.net.sportustoz.dto;

import lombok.Data;

@Data
public class ScoreCreateDto {
    private Long userId;
    private Double secund;
    private Double minute;
    private Integer pullUp;
}
