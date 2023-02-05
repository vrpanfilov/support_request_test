package ru.skillbox.zerone.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.skillbox.zerone.backend.model.dto.SupportRequestEditDto;
import ru.skillbox.zerone.backend.model.dto.request.SupportRequestListDTO;
import ru.skillbox.zerone.backend.service.SupportRequestEditService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/support/edit")
public class SupportRequestEditController {
    private final SupportRequestEditService supportRequestEditService;

    @GetMapping("/")
    public String defaultPage(Model model) {
        List<SupportRequestEditDto> supportRequests =
                supportRequestEditService.getNotClosedRequests();
        SupportRequestListDTO supportRequestListDTO = SupportRequestListDTO.builder()
                .supportRequest(supportRequests)
                .build();
        model.addAttribute("requests", supportRequestListDTO);
        return "edit_support";
    }

    @PostMapping("/")
    public String saveChanges(SupportRequestListDTO requests) {
        return "redirect:/api/v1/support/edit/";
    }
}
