package com.example.hospital.service;

import com.example.hospital.model.Maqueiro;
import com.example.hospital.model.Solicitacao;
import com.example.hospital.model.Status;
import com.example.hospital.repository.SolicitacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.hospital.model.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SolicitacaoServiceTest {

    @Mock
    private SolicitacaoRepository solicitacaoRepository;

    @InjectMocks
    private SolicitacaoService solicitacaoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSolicitacoes() {
        // Mock data
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setId(1L);
        Solicitacao solicitacao2 = new Solicitacao();
        solicitacao2.setId(2L);
        List<Solicitacao> solicitacoes = Arrays.asList(solicitacao1, solicitacao2);

        // Mockando comportamento do repository
        when(solicitacaoRepository.findAll()).thenReturn(solicitacoes);

        // Executando o método a ser testado
        List<Solicitacao> result = solicitacaoService.getAllSolicitacoes();

        // Verificando resultados esperados
        assertEquals(2, result.size());
        assertEquals(solicitacao1, result.get(0));
        assertEquals(solicitacao2, result.get(1));

        // Verificando interação com o mock
        verify(solicitacaoRepository, times(1)).findAll();
    }

    @Test
    public void testAceitarSolicitacao() {
        // Mock data
        Long solicitacaoId = 1L;
        Maqueiro maqueiro = new Maqueiro();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(solicitacaoId);
        solicitacao.setStatus(0);

        // Mockando comportamento do repository
        when(solicitacaoRepository.findById(solicitacaoId)).thenReturn(Optional.of(solicitacao));
        when(solicitacaoRepository.save(any(Solicitacao.class))).thenReturn(solicitacao);

        // Executando o método a ser testado
        Solicitacao result = solicitacaoService.aceitarSolicitacao(solicitacaoId, maqueiro);

        // Verificando resultados esperados
        assertEquals(solicitacaoId, result.getId());
        assertEquals(EM_TRANSPORTE, result.getStatus()); // Verifica se o status foi atualizado para 1 (em andamento)
        assertEquals(maqueiro, result.getMaqueiro());
        assertNotNull(result.getDataHora());

        // Verificando interação com o mock
        verify(solicitacaoRepository, times(1)).findById(solicitacaoId);
        verify(solicitacaoRepository, times(1)).save(any(Solicitacao.class));
    }

    @Test
    public void testRecusarSolicitacao() {
        // Mock data
        Long solicitacaoId = 1L;
        Maqueiro maqueiro = new Maqueiro();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(solicitacaoId);
        solicitacao.setStatus(0);

        // Mockando comportamento do repository
        when(solicitacaoRepository.findById(solicitacaoId)).thenReturn(Optional.of(solicitacao));
        when(solicitacaoRepository.save(any(Solicitacao.class))).thenReturn(solicitacao);

        // Executando o método a ser testado
        Solicitacao result = solicitacaoService.recusarSolicitacao(solicitacaoId, maqueiro);

        // Verificando resultados esperados
        assertEquals(solicitacaoId, result.getId());
        assertEquals(RECUSADA, result.getStatus()); // Verifica se o status foi atualizado para 3 (recusada)

        // Verificando interação com o mock
        verify(solicitacaoRepository, times(1)).findById(solicitacaoId);
        verify(solicitacaoRepository, times(1)).save(any(Solicitacao.class));
    }

    @Test
    public void testConcluirSolicitacao() {
        // Mock data
        Long solicitacaoId = 1L;
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(solicitacaoId);
        solicitacao.setStatus(1);

        // Mockando comportamento do repository
        when(solicitacaoRepository.findById(solicitacaoId)).thenReturn(Optional.of(solicitacao));
        when(solicitacaoRepository.save(any(Solicitacao.class))).thenReturn(solicitacao);

        // Executando o método a ser testado
        Solicitacao result = solicitacaoService.concluirSolicitacao(solicitacaoId);

        // Verificando resultados esperados
        assertEquals(solicitacaoId, result.getId());
        assertEquals(CONCLUIDO, result.getStatus()); // Verifica se o status foi atualizado para 2 (concluída)

        // Verificando interação com o mock
        verify(solicitacaoRepository, times(1)).findById(solicitacaoId);
        verify(solicitacaoRepository, times(1)).save(any(Solicitacao.class));
    }
}
