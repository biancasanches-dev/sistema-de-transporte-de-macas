package com.example.hospital;

import com.example.hospital.model.*;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.PacienteService;
import com.example.hospital.service.SolicitacaoService;
import com.example.hospital.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DashboardService dashboardService;


    private List<Solicitacao> solicitacoes;

    @Override
    public void run(String... args) throws Exception {

        // Cria o terceiro usuário se ele não existir
//        if (usuarioService.getUsuarioPorNome("usuario3") == null) {
//            ProfissionalDeSaude usuario3 = new ProfissionalDeSaude();
//            usuario3.setNome("usuario3");
//            usuario3.setSenha("senha3");
//
//            usuarioService.saveUsuario(usuario3);
//        }
//
//        if (usuarioService.getUsuarioPorNome("usuario1") == null) {
//            Maqueiro usuario1 = new Maqueiro();
//            usuario1.setNome("usuario1");
//            usuario1.setSenha("senha1");
//
//            usuarioService.saveUsuario(usuario1);
//        }

//
//        // Cria um paciente de exemplo
//        Paciente paciente1 = new Paciente("João");
//        dashboardService.salvarPaciente(paciente1);
//        Solicitacao solicitacao1 = new Solicitacao();
//        solicitacao1.setPaciente(paciente1);
//        solicitacao1.setOrigem("Sala 101");
//        solicitacao1.setDestino("Sala 202");
//        solicitacao1.setStatus(0);
//        solicitacao1.setPrioridade(1);
//        solicitacao1.setDataHora(LocalDateTime.now().minusDays(1));
//        solicitacaoService.saveSolicitacao(solicitacao1);
//
//        // Solicitacao 2
//        Paciente paciente2 = new Paciente("Maria");
//        dashboardService.salvarPaciente(paciente2);
//        Solicitacao solicitacao2 = new Solicitacao();
//        solicitacao2.setPaciente(paciente2);
//        solicitacao2.setOrigem("Sala 203");
//        solicitacao2.setDestino("Sala 304");
//        solicitacao2.setStatus(1);
//        solicitacao2.setPrioridade(2);
//        solicitacao2.setDataHora(LocalDateTime.now().minusHours(3));
//        solicitacaoService.saveSolicitacao(solicitacao2);
//
//        // Solicitacao 3
//        Paciente paciente3 = new Paciente("Carlos");
//        dashboardService.salvarPaciente(paciente3);
//        Solicitacao solicitacao3 = new Solicitacao();
//        solicitacao3.setPaciente(paciente3);
//        solicitacao3.setOrigem("Sala 405");
//        solicitacao3.setDestino("Sala 506");
//        solicitacao3.setStatus(2);
//        solicitacao3.setPrioridade(3);
//        solicitacao3.setDataHora(LocalDateTime.now().minusDays(2));
//        solicitacaoService.saveSolicitacao(solicitacao3);
//
//        // Solicitacao 4
//        Paciente paciente4 = new Paciente("Ana");
//        dashboardService.salvarPaciente(paciente4);
//        Solicitacao solicitacao4 = new Solicitacao();
//        solicitacao4.setPaciente(paciente4);
//        solicitacao4.setOrigem("Sala 101");
//        solicitacao4.setDestino("Sala 204");
//        solicitacao4.setStatus(0);
//        solicitacao4.setPrioridade(3);
//        solicitacao4.setDataHora(LocalDateTime.now().minusHours(2));
//        solicitacaoService.saveSolicitacao(solicitacao4);
//
//        // Solicitacao 5
//        Paciente paciente5 = new Paciente("Luís");
//        dashboardService.salvarPaciente(paciente5);
//        Solicitacao solicitacao5 = new Solicitacao();
//        solicitacao5.setPaciente(paciente5);
//        solicitacao5.setOrigem("Sala 302");
//        solicitacao5.setDestino("Sala 101");
//        solicitacao5.setStatus(1);
//        solicitacao5.setPrioridade(1);
//        solicitacao5.setDataHora(LocalDateTime.now().minusMinutes(45));
//        solicitacaoService.saveSolicitacao(solicitacao5);
//
//        // Solicitacao 6
//        Paciente paciente6 = new Paciente("Beatriz");
//        dashboardService.salvarPaciente(paciente6);
//        Solicitacao solicitacao6 = new Solicitacao();
//        solicitacao6.setPaciente(paciente6);
//        solicitacao6.setOrigem("Sala 505");
//        solicitacao6.setDestino("Sala 101");
//        solicitacao6.setStatus(2);
//        solicitacao6.setPrioridade(2);
//        solicitacao6.setDataHora(LocalDateTime.now().minusHours(5));
//        solicitacaoService.saveSolicitacao(solicitacao6);
//
//        // Solicitacao 7
//        Paciente paciente7 = new Paciente("Fernanda");
//        dashboardService.salvarPaciente(paciente7);
//        Solicitacao solicitacao7 = new Solicitacao();
//        solicitacao7.setPaciente(paciente7);
//        solicitacao7.setOrigem("Sala 101");
//        solicitacao7.setDestino("Sala 304");
//        solicitacao7.setStatus(0);
//        solicitacao7.setPrioridade(1);
//        solicitacao7.setDataHora(LocalDateTime.now().minusDays(3));
//        solicitacaoService.saveSolicitacao(solicitacao7);
//
//        // Solicitacao 8
//        Paciente paciente8 = new Paciente("Gustavo");
//        dashboardService.salvarPaciente(paciente8);
//        Solicitacao solicitacao8 = new Solicitacao();
//        solicitacao8.setPaciente(paciente8);
//        solicitacao8.setOrigem("Sala 402");
//        solicitacao8.setDestino("Sala 506");
//        solicitacao8.setStatus(1);
//        solicitacao8.setPrioridade(3);
//        solicitacao8.setDataHora(LocalDateTime.now().minusMinutes(30));
//        solicitacaoService.saveSolicitacao(solicitacao8);
//
//        // Solicitacao 9
//        Paciente paciente9 = new Paciente("Patrícia");
//        dashboardService.salvarPaciente(paciente9);
//        Solicitacao solicitacao9 = new Solicitacao();
//        solicitacao9.setPaciente(paciente9);
//        solicitacao9.setOrigem("Sala 101");
//        solicitacao9.setDestino("Sala 405");
//        solicitacao9.setStatus(2);
//        solicitacao9.setPrioridade(1);
//        solicitacao9.setDataHora(LocalDateTime.now().minusDays(1).minusHours(2));
//        solicitacaoService.saveSolicitacao(solicitacao9);
//
//        // Solicitacao 10
//        Paciente paciente10 = new Paciente("Ricardo");
//        dashboardService.salvarPaciente(paciente10);
//        Solicitacao solicitacao10 = new Solicitacao();
//        solicitacao10.setPaciente(paciente10);
//        solicitacao10.setOrigem("Sala 303");
//        solicitacao10.setDestino("Sala 101");
//        solicitacao10.setStatus(0);
//        solicitacao10.setPrioridade(2);
//        solicitacao10.setDataHora(LocalDateTime.now().minusDays(2).minusMinutes(15));
//        solicitacaoService.saveSolicitacao(solicitacao10);

//        solicitacoes = solicitacaoService.getAllSolicitacoes();
//
//        for (Solicitacao solicitacao : solicitacoes) {
//            Incidente incidente = new Incidente();
//
//            incidente.setSolicitacao(solicitacao);
//            incidente.setDescricao("Descrição do incidente");
//
//            dashboardService.saveIncidente(incidente);
//        };
//
//        solicitacaoService.deleteSolicitacao(15);
//        solicitacaoService.deleteSolicitacao(18);

    }


}
