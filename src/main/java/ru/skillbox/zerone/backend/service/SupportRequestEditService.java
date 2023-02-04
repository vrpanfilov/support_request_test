package ru.skillbox.zerone.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.skillbox.zerone.backend.model.dto.SupportRequestEditDto;
import ru.skillbox.zerone.backend.model.entity.SupportRequest;
import ru.skillbox.zerone.backend.model.enumerated.SupportRequestStatus;
import ru.skillbox.zerone.backend.repository.SupportRequestRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.skillbox.zerone.backend.model.enumerated.SupportRequestStatus.CLOSED;

@Service
@AllArgsConstructor
public class SupportRequestEditService {
    private final SupportRequestRepository supportRequestRepository;

    public List<SupportRequestEditDto> getNotClosedRequests() {
        List<SupportRequest> requests =
                supportRequestRepository.findAllByStatusNot(CLOSED)
                        .stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).toList();
        List<SupportRequestEditDto> dtos = new ArrayList<>();
        requests.forEach(request -> {
            SupportRequestEditDto dto = SupportRequestEditDto.builder()
                    .id(request.getId())
                    .email(request.getEmail())
                    .fullName(request.getFirstName() + ' ' + request.getLastName())
                    .message(request.getMessage())
                    .status(request.getStatus())
                    .createdAt(request.getTime().toString())
                    .build();
            dtos.add(dto);
        });
        return dtos;
    }

    @Bean
    public ApplicationRunner test() {
        return args -> {
        };
    }
}
