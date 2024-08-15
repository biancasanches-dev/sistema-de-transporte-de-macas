package com.example.hospital.controller;

import com.example.hospital.model.dashboard.DashboardData;
import com.example.hospital.model.incidente.Incidente;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.IncidenteService;
import com.example.hospital.service.SolicitacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/incidentes")
public class IncidenteController {

    private final IncidenteService incidenteService;
    private final SolicitacaoService solicitacaoService;
    private final DashboardService dashboardService;

    public IncidenteController(IncidenteService incidenteService, SolicitacaoService solicitacaoService, DashboardService dashboardService) {
        this.incidenteService = incidenteService;
        this.solicitacaoService = solicitacaoService;
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String getIncidentes(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("usuario", usuario);
        return "incidentes";
    }

    @GetMapping("/{id}")
    public String getIncidente(@PathVariable Long id, Model model, HttpSession session) {
        Incidente incidente = incidenteService.getIncidenteById(id);
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("usuario", usuario);
        model.addAttribute("incidente", incidente);
        return "incidente";
    }


    @GetMapping("/solicitacao/{id}/relatar")
    public String getRelatarIncidente(@PathVariable Long id, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("solicitacao", solicitacao);
        model.addAttribute("incidente", new Incidente());
        return "relatarIncidente";
    }

    @PostMapping("/solicitacao/{id}/relatar")
    public String cadastrarIncidente(@PathVariable Long id, @ModelAttribute Incidente incidente, Model model, RedirectAttributes redirectAttributes) {
        try {
            Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
            incidente.setSolicitacao(solicitacao);
            incidenteService.saveIncidente(incidente);
            DashboardData data = dashboardService.getDashboardData();
            model.addAttribute("data", data);
            redirectAttributes.addFlashAttribute("successMessage", "Solicitação enviada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao enviar a solicitação.");
        }
        return "redirect:/incidentes";
    }

}
