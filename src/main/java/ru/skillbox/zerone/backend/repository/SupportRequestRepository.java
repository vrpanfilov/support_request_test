package ru.skillbox.zerone.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.zerone.backend.model.entity.SupportRequest;
import ru.skillbox.zerone.backend.model.enumerated.SupportRequestStatus;

import java.util.List;

public interface SupportRequestRepository extends JpaRepository<SupportRequest, Long> {
    List<SupportRequest> findAllByStatusNot(SupportRequestStatus status);
}
