package com.example.hospital.controller;

import com.example.hospital.model.*;
import com.example.hospital.service.DashboardService;
import com.example.hospital.service.IncidenteService;
import com.example.hospital.service.SolicitacaoService;
import com.example.hospital.service.impl.IncidenteServiceImpl;
import com.example.hospital.service.impl.SolicitacaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(DashboardController.class)
public class DashboardControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private DashboardService dashboardService;

    @MockBean
    private SolicitacaoService solicitacaoService;

    @MockBean
    private IncidenteService incidenteService;

    @Test
    public void testGetDashboard() {
        Usuario usuario = new Maqueiro();
        usuario.setNome("user");

        when(dashboardService.getDashboardData()).thenReturn(new DashboardData());
        webTestClient.get().uri("/dashboard")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("home");
    }

    @Test
    public void testNovaSolicitacao() {
        Usuario usuario = new ProfissionalDeSaude();
        usuario.setNome("user");

        when(solicitacaoService.saveSolicitacao(any(Solicitacao.class))).thenReturn(new Solicitacao());
        webTestClient.post().uri("/nova-solicitacao")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new Solicitacao())
                .exchange()
                .expectStatus().is3xxRedirection()
                .expectHeader().valueEquals("Location", "/dashboard");
    }

    @Test
    public void testGetSolicitacoes() {
        Usuario usuario = new Maqueiro();
        usuario.setNome("user");

        when(dashboardService.getDashboardData()).thenReturn(new DashboardData());
        webTestClient.get().uri("/solicitacoes")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("solicitacoes");
    }

    @Test
    public void testGetRelatarIncidente() {
        Long id = 1L;
        Usuario usuario = new ProfissionalDeSaude();
        usuario.setNome("user");

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(id);
        when(solicitacaoService.getSolicitacaoById(id)).thenReturn(solicitacao);

        webTestClient.get().uri("/solicitacoes/{id}/relatarIncidente", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("relatarIncidente");
    }

    @Test
    public void testCadastrarIncidente() {
        Long id = 1L;
        Incidente incidente = new Incidente();

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(id);

        when(solicitacaoService.getSolicitacaoById(id)).thenReturn(solicitacao);
        when(incidenteService.saveIncidente(any(Incidente.class))).thenReturn(incidente);

        webTestClient.post().uri("/solicitacoes/{id}/relatarIncidente", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new Incidente())
                .exchange()
                .expectStatus().is3xxRedirection()
                .expectHeader().valueEquals("Location", "/incidentes");
    }

    @Test
    public void testGetIncidentes() {
        Usuario usuario = new Maqueiro();
        usuario.setNome("user");

        when(dashboardService.getDashboardData()).thenReturn(new DashboardData());
        webTestClient.get().uri("/incidentes")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("incidentes");
    }

    @Test
    public void testGetIncidente() {
        Long id = 1L;
        Incidente incidente = new Incidente();

        when(incidenteService.getIncidenteById(id)).thenReturn(incidente);
        webTestClient.get().uri("/incidentes/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("incidente");
    }
//
//    @Test
//    public void testAceitarSolicitacao() {
//        Long id = 1L;
//        Usuario usuario = new Maqueiro();
//        usuario.setId(1L);
//        Solicitacao solicitacao = new Solicitacao();
//
//        when(solicitacaoService.aceitarSolicitacao(id, (Maqueiro) usuario)).thenReturn(true);
//
//        webTestClient.get().uri("/solicitacoes/{id}/aceitar", id)
//                .exchange()
//                .expectStatus().is3xxRedirection()
//                .expectHeader().valueEquals("Location", "/dashboard");
//    }
//
//    @Test
//    public void testRecusarSolicitacao() {
//        Long id = 1L;
//        Usuario usuario = new Maqueiro();
//        usuario.setId(1L);
//
//        when(solicitacaoService.recusarSolicitacao(id, (Maqueiro) usuario)).thenReturn(true);
//
//        webTestClient.get().uri("/solicitacoes/{id}/recusar", id)
//                .exchange()
//                .expectStatus().is3xxRedirection()
//                .expectHeader().valueEquals("Location", "/dashboard");
//    }
//
//    @Test
//    public void testConcluirSolicitacao() {
//        Long id = 1L;
//
//        when(solicitacaoService.concluirSolicitacao(id)).thenReturn(true);
//
//        webTestClient.get().uri("/solicitacoes/{id}/concluir", id)
//                .exchange()
//                .expectStatus().is3xxRedirection()
//                .expectHeader().valueEquals("Location", "/solicitacoes");
//    }
}
