package com.example.hospital.controller;

import com.example.hospital.model.dashboard.DashboardData;
import com.example.hospital.model.incidente.Incidente;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.IncidenteService;
import com.example.hospital.service.SolicitacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getIncidentes(Model model) {
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        return "incidentes";
    }

    @GetMapping("/{id}")
    public String getIncidente(@PathVariable Long id, Model model) {
        Incidente incidente = incidenteService.getIncidenteById(id);
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("incidente", incidente);
        return "incidente";
    }


    @GetMapping("/solicitacao/{id}/relatar")
    public String getRelatarIncidente(@PathVariable Long id, Model model) {
        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        model.addAttribute("solicitacao", solicitacao);
        model.addAttribute("incidente", new Incidente());
        return "relatarIncidente";
    }

    @PostMapping("/solicitacao/{id}/relatar")
    public String cadastrarIncidente(@PathVariable Long id, @ModelAttribute Incidente incidente, Model model) {
        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        incidente.setSolicitacao(solicitacao);
        incidenteService.saveIncidente(incidente);
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);

        return "redirect:/incidentes";
    }

}
