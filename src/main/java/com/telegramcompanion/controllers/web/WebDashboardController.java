package com.telegramcompanion.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebDashboardController {
    @GetMapping("/")
    public String getDashboard(Model model) {

        return "public/index";
    }
}
