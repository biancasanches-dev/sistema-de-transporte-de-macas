package com.example.hospital.controller;

import com.example.hospital.model.*;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.SolicitacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;
    private final SolicitacaoService solicitacaoService;
    private final HttpSession httpSession;

    public DashboardController(DashboardService dashboardService, SolicitacaoService solicitacaoService, HttpSession httpSession) {
        this.dashboardService = dashboardService;
        this.solicitacaoService = solicitacaoService;
        this.httpSession = httpSession;
    }

    private void getData(Model model) {
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        getData(model);
        model.addAttribute("usuario", usuario);
        return "home";
    }

    @GetMapping("/nova-solicitacao")
    public String novaSolicitacao(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        getData(model);
        model.addAttribute("usuario", usuario);
        model.addAttribute("solicitacao", new Solicitacao());
        return "novaSolicitacao";
    }

    @PostMapping("/nova-solicitacao")
    public String cadastrarSolicitacao(@ModelAttribute Solicitacao solicitacao, RedirectAttributes redirectAttributes) {
        try {
            dashboardService.salvarPaciente(solicitacao.getPaciente());
            solicitacao.setStatus(0);
            solicitacaoService.saveSolicitacao(solicitacao);
            redirectAttributes.addFlashAttribute("successMessage", "Solicitação enviada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao enviar a solicitação.");
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/solicitacoes")
    public String getSolicitacoes(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        getData(model);
        model.addAttribute("usuario", usuario);
        return "solicitacoes";
    }

    @GetMapping("/solicitacoes/{id}/relatarIncidente")
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

    @PostMapping("/solicitacoes/{id}/relatarIncidente")
    public String cadastrarIncidente(@PathVariable Long id, @ModelAttribute Incidente incidente, Model model, RedirectAttributes redirectAttributes) {
        try {
            Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
            incidente.setSolicitacao(solicitacao);
            dashboardService.saveIncidente(incidente);
            getData(model);
            redirectAttributes.addFlashAttribute("successMessage", "Solicitação enviada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao enviar a solicitação.");
        }
        return "redirect:/incidentes";
    }

    @GetMapping("/incidentes")
    public String getIncidentes(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        getData(model);
        model.addAttribute("usuario", usuario);
        return "incidentes";
    }

    @GetMapping("/incidentes/{id}")
    public String getIncidente(@PathVariable Long id, Model model, HttpSession session) {
        Incidente incidente = dashboardService.getIncidenteById(id);
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return "redirect:/login";
        }
        getData(model);
        model.addAttribute("usuario", usuario);
        model.addAttribute("incidente", incidente);
        return "incidente";
    }

    @GetMapping("/solicitacoes/{id}/aceitar")
    public String aceitarSolicitacao(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario instanceof Maqueiro) {
            solicitacaoService.aceitarSolicitacao(id, (Maqueiro) usuario);
            return "redirect:/dashboard";
        }
        else {
            return null;
        }
    }

    @GetMapping("/solicitacoes/{id}/recusar")
    public String recusarSolicitacao(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario instanceof Maqueiro) {
            solicitacaoService.recusarSolicitacao(id, (Maqueiro) usuario);
            return "redirect:/dashboard";
        }
        else {
            return null;
        }
    }

    @GetMapping("/solicitacoes/{id}/concluir")
    public String concluirSolicitacao(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario instanceof Maqueiro) {
            solicitacaoService.concluirSolicitacao(id);
            return "redirect:/solicitacoes";
        }
        else {
            return null;
        }
    }

}
