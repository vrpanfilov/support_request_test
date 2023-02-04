package ru.skillbox.zerone.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.skillbox.zerone.backend.model.dto.SupportRequestEditDto;
import ru.skillbox.zerone.backend.service.SupportRequestEditService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/support/edit")
public class SupportRequestEditController {
    private final SupportRequestEditService supportRequestEditService;

    @GetMapping("/")
    public String defaultPage(Model model) {
        List<SupportRequestEditDto> requests =
                supportRequestEditService.getNotClosedRequests();
        model.addAttribute("requests", requests);

        ArrayList<SupportRequestEditDto> response = new ArrayList<>();
        for (int i = 0; i < requests.size(); i++) {
            response.add(new SupportRequestEditDto());
        }
        model.addAttribute("response", response);
        return "edit_support";
    }

    @PostMapping("/")
    public String saveChanges(Model model, @ModelAttribute ArrayList<SupportRequestEditDto> response) {
        response = response;
        return "redirect:/api/v1/support/edit/";
    }
}
