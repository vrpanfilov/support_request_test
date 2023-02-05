package ru.skillbox.zerone.backend.model.dto.request;

import lombok.Builder;
import lombok.Data;
import ru.skillbox.zerone.backend.model.dto.SupportRequestEditDto;

import java.util.List;

@Data
@Builder
public class SupportRequestListDTO {
    private Integer offset; //Поля offset, limit и total сейчас не используются. Это задел под постраничную загрузку (пагинацию)
    private Integer limit;
    private Integer total;
    private List<SupportRequestEditDto> supportRequest;
}
