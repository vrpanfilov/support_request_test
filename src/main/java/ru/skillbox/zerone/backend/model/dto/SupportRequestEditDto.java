package ru.skillbox.zerone.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skillbox.zerone.backend.model.enumerated.SupportRequestStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupportRequestEditDto {
    private Long id;
    private String email;
    private String fullName;
    private String message;
    private SupportRequestStatus status;
    private String createdAt;
}
