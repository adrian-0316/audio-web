package com.adrian.audio_web.controllers;

import com.adrian.audio_web.dto.RequestForm;
import com.adrian.audio_web.enums.ServiceType;
import com.adrian.audio_web.service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestService service;

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("requestForm", new RequestForm());
        model.addAttribute("services", ServiceType.values());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@Valid @ModelAttribute RequestForm form,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("services", ServiceType.values());
            return "contact";
        }

        service.save(form);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}