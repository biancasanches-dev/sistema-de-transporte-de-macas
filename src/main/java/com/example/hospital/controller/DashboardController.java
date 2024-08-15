package com.example.hospital.controller;

import com.example.hospital.model.dashboard.DashboardData;
import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

//    private void getData(Model model) {
//        DashboardData data = dashboardService.getDashboardData();
//        model.addAttribute("data", data);
//    }

    @GetMapping
    public String getDashboard(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("usuario", usuario);
        return "home";
    }

}
