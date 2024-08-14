package com.example.hospital.service;

import com.example.hospital.model.DashboardData;
import com.example.hospital.model.Incidente;
import com.example.hospital.model.Solicitacao;
import com.example.hospital.repository.IncidenteRepository;
import com.example.hospital.repository.PacienteRepository;
import com.example.hospital.service.impl.SolicitacaoServiceImpl;
import com.example.hospital.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DashboardServiceTest {

    @Mock
    private UsuarioServiceImpl usuarioService;

    @Mock
    private SolicitacaoServiceImpl solicitacaoService;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private IncidenteRepository incidenteRepository;

    @InjectMocks
    private DashboardService dashboardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDashboardData() {
        // Mock data
        List<Solicitacao> solicitacoesAbertas = new ArrayList<>();
        Solicitacao solicitacaoAberta = new Solicitacao();
//        solicitacaoAberta.setId(1L);
        solicitacoesAbertas.add(solicitacaoAberta);

        List<Solicitacao> solicitacoesEmAndamento = new ArrayList<>();
        Solicitacao solicitacaoEmAndamento = new Solicitacao();
        solicitacaoEmAndamento.setId(2L);
        solicitacoesEmAndamento.add(solicitacaoEmAndamento);

        List<Solicitacao> solicitacoesEncerradas = new ArrayList<>();
        Solicitacao solicitacaoEncerrada = new Solicitacao();
        solicitacaoEncerrada.setId(3L);
        solicitacoesEncerradas.add(solicitacaoEncerrada);

        List<Incidente> incidentes = new ArrayList<>();
        Incidente incidente = new Incidente();
//        incidente.setId(1L);
        incidentes.add(incidente);

        // Mockando comportamentos dos serviços
        when(solicitacaoService.getSolicitacoesByPrioridade()).thenReturn(solicitacoesAbertas);
        when(solicitacaoService.getSolicitacoesByStatus(1)).thenReturn(solicitacoesEmAndamento);
        when(solicitacaoService.getSolicitacoesByStatusList(Arrays.asList(2, 3))).thenReturn(solicitacoesEncerradas);
        when(incidenteRepository.findAll()).thenReturn(incidentes);

        // Executando o método a ser testado
        DashboardData dashboardData = dashboardService.getDashboardData();

        // Verificando resultados esperados
        assertEquals(solicitacoesAbertas, dashboardData.getSolicitacoesAbertas());
        assertEquals(solicitacoesEmAndamento, dashboardData.getSolicitacoesEmAndamento());
        assertEquals(solicitacoesEncerradas, dashboardData.getSolicitacoesEncerradas());
        assertEquals(incidentes, dashboardData.getIncidentes());

        // Verificando interações com os mocks
        verify(solicitacaoService, times(1)).getSolicitacoesByPrioridade();
        verify(solicitacaoService, times(1)).getSolicitacoesByStatus(1);
        verify(solicitacaoService, times(1)).getSolicitacoesByStatusList(Arrays.asList(2, 3));
        verify(incidenteRepository, times(1)).findAll();
    }

    // Adicione aqui testes para os métodos de PacienteService e IncidenteService conforme necessário
}
