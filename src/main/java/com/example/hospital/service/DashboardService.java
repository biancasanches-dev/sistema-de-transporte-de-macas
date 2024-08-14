package com.example.hospital.service;

import com.example.hospital.model.DashboardData;
import com.example.hospital.model.Incidente;
import com.example.hospital.model.Solicitacao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DashboardService {

    private final SolicitacaoService solicitacaoService;
    private final IncidenteService incidenteService;


    public DashboardService(SolicitacaoService solicitacaoService, IncidenteService incidenteService) {
        this.solicitacaoService = solicitacaoService;
        this.incidenteService = incidenteService;
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

        List<Incidente> getIncidentes = incidenteService.getAllIncidentes();
        Collections.sort(getIncidentes);
        data.setIncidentes(getIncidentes);

        return data;
    }


}
