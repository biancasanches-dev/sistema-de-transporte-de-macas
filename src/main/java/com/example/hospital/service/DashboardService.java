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
import java.util.Collections;
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
        Collections.sort(getSolicitacoesFechadas);
        data.setSolicitacoesEncerradas(getSolicitacoesFechadas);

        List<Solicitacao> getSolicitacoesEmAndamento = solicitacaoService.getSolicitacoesByStatus(1);
        Collections.sort(getSolicitacoesEmAndamento);
        data.setSolicitacoesEmAndamento(getSolicitacoesEmAndamento);

        List<Incidente> getIncidentes = getAllIncidentes();
        Collections.sort(getIncidentes);
        data.setIncidentes(getIncidentes);

        return data;
    }

    @Override
    public Paciente buscarPaciente(Paciente paciente) {
        return pacienteRepository.findByNome(paciente.getNome());
    }

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
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

    public void deletarIncidente(Long id) {
        incidenteRepository.deleteById(id);
    }
}
