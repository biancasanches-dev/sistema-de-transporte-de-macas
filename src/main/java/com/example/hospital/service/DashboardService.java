package com.example.hospital.service;

import com.example.hospital.model.DashboardData;
import com.example.hospital.model.Incidente;
import com.example.hospital.model.Paciente;
import com.example.hospital.model.Solicitacao;
import com.example.hospital.repository.IncidenteRepository;
import com.example.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DashboardService implements IncidenteService, PacienteService {

    private final UsuarioService usuarioService;
    private SolicitacaoService solicitacaoService;
    private PacienteRepository pacienteRepository;
    private IncidenteRepository incidenteRepository;

    @Autowired
    public DashboardService(UsuarioService usuarioService, SolicitacaoService solicitacaoService, PacienteRepository pacienteRepository, IncidenteRepository incidenteRepository) {
        this.usuarioService = usuarioService;
        this.solicitacaoService = solicitacaoService;
        this.pacienteRepository = pacienteRepository;
        this.incidenteRepository = incidenteRepository;
    }

    public DashboardData getDashboardData() {
        DashboardData data = new DashboardData();

        List<Solicitacao> getSolicitacoesAbertas = solicitacaoService.getSolicitacoesByPrioridade();
        data.setSolicitacoesAbertas(getSolicitacoesAbertas);

        List<Integer> statusList = Arrays.asList(2, 3);
        List<Solicitacao> getSolicitacoesFechadas = solicitacaoService.getSolicitacoesByStatusList(statusList);
        data.setSolicitacoesEncerradas(getSolicitacoesFechadas);

        List<Solicitacao> getSolicitacoesEmAndamento = solicitacaoService.getSolicitacoesByStatus(1);
        data.setSolicitacoesEmAndamento(getSolicitacoesEmAndamento);

        List<Incidente> getIncidentes = getAllIncidentes();
        data.setIncidentes(getIncidentes);

        return data;
    }

    @Override
    public Paciente buscarPaciente(Paciente paciente) {
        return pacienteRepository.findByNome(paciente.getNome());
    }

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        Paciente pacienteExistente = pacienteRepository.findByNome(paciente.getNome());
        if (pacienteExistente != null) {
            return pacienteExistente;
        } else {
            return pacienteRepository.save(paciente);
        }
    }

    //IncidenteService
    @Override
    public List<Incidente> getAllIncidentes() {
        return incidenteRepository.findAll();
    }

    @Override
    public Incidente getIncidenteById(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    @Override
    public Incidente saveIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }
}
