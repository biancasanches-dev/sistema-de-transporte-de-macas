package com.example.hospital;

import com.example.hospital.model.incidente.Incidente;
import com.example.hospital.model.paciente.Paciente;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.usuario.ProfissionalDeSaude;
import com.example.hospital.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UsuarioService usuarioService;
    private final SolicitacaoService solicitacaoService;
    private final PacienteService pacienteService;
    private final IncidenteService incidenteService;

    public DatabaseSeeder(UsuarioService usuarioService, SolicitacaoService solicitacaoService, PacienteService pacienteService, IncidenteService incidenteService) {
        this.usuarioService = usuarioService;
        this.solicitacaoService = solicitacaoService;
        this.pacienteService = pacienteService;
        this.incidenteService = incidenteService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Criar usuários garantindo que não sejam duplicados
        if (usuarioService.getUsuarioPorNome("usuario1") == null) {
            Maqueiro usuario1 = new Maqueiro();
            usuario1.setNome("usuario1");
            usuario1.setSenha("senha1");

            usuarioService.saveUsuario(usuario1);
        }
        if (usuarioService.getUsuarioPorNome("usuario3") == null) {
            ProfissionalDeSaude usuario3 = new ProfissionalDeSaude();
            usuario3.setNome("usuario3");
            usuario3.setSenha("senha3");

            usuarioService.saveUsuario(usuario3);
        }

        // Criar solicitações de exemplo
        Paciente paciente1 = new Paciente("João");
        pacienteService.salvarPaciente(paciente1);
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setPaciente(paciente1);
        solicitacao1.setOrigem("Sala 101");
        solicitacao1.setDestino("Sala 202");
        solicitacao1.setStatus(0); // 0 - Pendente, 1 - Em andamento, 2 - Concluída
        solicitacao1.setPrioridade(1); // 1 - Alta, 2 - Média, 3 - Baixa
        solicitacao1.setDataHora(LocalDateTime.now().minusDays(1)); //Alterar valores opcionalemnte
        solicitacaoService.saveSolicitacao(solicitacao1);

        //Criar Incidentes de exemplo
        Incidente incidente = new Incidente();

        incidente.setSolicitacao(solicitacao1);
        incidente.setDescricao("Descrição do incidente");

        incidenteService.saveIncidente(incidente);

        //Todos os services tem métodos de busca, atualização e deleção
//        incidenteService.deletarIncidente(Long.valueOf(1));
    }
}
