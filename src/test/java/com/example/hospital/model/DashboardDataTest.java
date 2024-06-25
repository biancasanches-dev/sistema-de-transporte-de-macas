package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DashboardDataTest {

    private DashboardData dashboardData;
    private List<Solicitacao> solicitacoesAbertas;
    private List<Solicitacao> solicitacoesEmAndamento;
    private List<Solicitacao> solicitacoesEncerradas;
    private List<Incidente> incidentes;
    private Solicitacao solicitacao;

    @BeforeEach
    public void setUp() {
        dashboardData = new DashboardData();
        solicitacoesAbertas = new ArrayList<>();
        solicitacoesEmAndamento = new ArrayList<>();
        solicitacoesEncerradas = new ArrayList<>();
        incidentes = new ArrayList<>();
        solicitacao = new Solicitacao();
        solicitacao.setOrigem("Sala 101");
        solicitacao.setDestino("Sala 202");
        solicitacao.setStatus(0);
        solicitacao.setPrioridade(1);
    }

    @Test
    public void testSetAndGetSolicitacao() {
        dashboardData.setSolicitacao(solicitacao);
        assertEquals(solicitacao, dashboardData.getSolicitacao());
    }

    @Test
    public void testSetAndGetSolicitacoesAbertas() {
        solicitacoesAbertas.add(solicitacao);
        dashboardData.setSolicitacoesAbertas(solicitacoesAbertas);
        assertEquals(solicitacoesAbertas, dashboardData.getSolicitacoesAbertas());
    }

    @Test
    public void testSetAndGetSolicitacoesEmAndamento() {
        solicitacoesEmAndamento.add(solicitacao);
        dashboardData.setSolicitacoesEmAndamento(solicitacoesEmAndamento);
        assertEquals(solicitacoesEmAndamento, dashboardData.getSolicitacoesEmAndamento());
    }

    @Test
    public void testSetAndGetSolicitacoesEncerradas() {
        solicitacoesEncerradas.add(solicitacao);
        dashboardData.setSolicitacoesEncerradas(solicitacoesEncerradas);
        assertEquals(solicitacoesEncerradas, dashboardData.getSolicitacoesEncerradas());
    }

    @Test
    public void testSetAndGetIncidentes() {
        Incidente incidente = new Incidente();
        incidente.setDescricao("Incidente de teste");
        incidente.setSolicitacao(solicitacao);
        incidentes.add(incidente);

        dashboardData.setIncidentes(incidentes);
        assertEquals(incidentes, dashboardData.getIncidentes());
    }
}
