package com.example.hospital.controller;

import com.example.hospital.model.dashboard.DashboardData;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.PacienteService;
import com.example.hospital.service.SolicitacaoService;
import com.example.hospital.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;
    private final DashboardService dashboardService;
    private final PacienteService pacienteService;
    private final UsuarioService usuarioService;

    public SolicitacaoController(SolicitacaoService solicitacaoService, DashboardService dashboardService, PacienteService pacienteService, UsuarioService usuarioService) {
        this.solicitacaoService = solicitacaoService;
        this.dashboardService = dashboardService;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
    }

    private Usuario getUsuario() {
        return usuarioService.getUsuarioLogado();
    }

    @GetMapping
    public String getSolicitacoes(Model model) {
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("usuario", getUsuario());
        return "solicitacoes";
    }

    @GetMapping("/cadastrar")
    public String novaSolicitacao(Model model) {
        DashboardData data = dashboardService.getDashboardData();
        model.addAttribute("data", data);
        model.addAttribute("usuario", getUsuario());
        model.addAttribute("solicitacao", new Solicitacao());
        return "novaSolicitacao";
    }

    @PostMapping("/cadastrar")
    public String cadastrarSolicitacao(@ModelAttribute Solicitacao solicitacao, RedirectAttributes redirectAttributes) {
        try {
            pacienteService.salvarPaciente(solicitacao.getPaciente());
            solicitacao.setStatus(0);
            solicitacaoService.saveSolicitacao(solicitacao);
            redirectAttributes.addFlashAttribute("successMessage", "Solicitação enviada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao enviar a solicitação.");
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/aceitar")
    public String aceitarSolicitacao(@PathVariable Long id) {
        if (getUsuario() instanceof Maqueiro) {
            solicitacaoService.aceitarSolicitacao(id, (Maqueiro) getUsuario());
            return "redirect:/";
        }
        else {
            return null;
        }
    }

    @GetMapping("/{id}/recusar")
    public String recusarSolicitacao(@PathVariable Long id) {
        if (getUsuario() instanceof Maqueiro) {
            solicitacaoService.recusarSolicitacao(id, (Maqueiro) getUsuario());
            return "redirect:/";
        }
        else {
            return null;
        }
    }

    @GetMapping("/{id}/concluir")
    public String concluirSolicitacao(@PathVariable Long id) {
        if (getUsuario() instanceof Maqueiro) {
            solicitacaoService.concluirSolicitacao(id);
            return "redirect:/";
        }
        else {
            return null;
        }
    }
}
