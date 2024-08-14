package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.example.hospital.model.enums.Prioridade;
import com.example.hospital.model.enums.Status;
import com.example.hospital.model.paciente.Paciente;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.model.usuario.Maqueiro;
import org.junit.jupiter.api.Test;

public class SolicitacaoTest {

    @Test
    public void testSetAndGetPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("João");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setPaciente(paciente);

        assertEquals(paciente, solicitacao.getPaciente());
    }

    @Test
    public void testSetAndGetMaqueiro() {
        Maqueiro maqueiro = new Maqueiro();
        maqueiro.setNome("Carlos");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setMaqueiro(maqueiro);

        assertEquals(maqueiro, solicitacao.getMaqueiro());
    }

    @Test
    public void testSetAndGetOrigem() {
        String origem = "Sala 101";
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setOrigem(origem);

        assertEquals(origem, solicitacao.getOrigem());
    }

    @Test
    public void testSetAndGetDestino() {
        String destino = "Sala 202";
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDestino(destino);

        assertEquals(destino, solicitacao.getDestino());
    }

    @Test
    public void testSetAndGetStatus() {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setStatus(1);

        assertEquals(Status.EM_TRANSPORTE, solicitacao.getStatus());
    }

    @Test
    public void testSetAndGetPrioridade() {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setPrioridade(2);

        assertEquals(Prioridade.MEDIA, solicitacao.getPrioridade());
    }

    @Test
    public void testSetAndGetDataHora() {
        LocalDateTime dataHora = LocalDateTime.of(2023, 6, 25, 15, 0);
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDataHora(dataHora);

        assertEquals(dataHora, solicitacao.getDataHora());
    }

    @Test
    public void testSetAndGetIsAceita() {
        Maqueiro maqueiro = new Maqueiro();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setAceita(maqueiro);

        assertTrue(solicitacao.isAceita());
        assertEquals(maqueiro, solicitacao.getMaqueiro());
    }

    @Test
    public void testSetAndGetIsRecusada() {
        Maqueiro maqueiro = new Maqueiro();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setRecusada(maqueiro);

        assertFalse(solicitacao.isAceita());
        assertEquals(maqueiro, solicitacao.getMaqueiro());
    }

    @Test
    public void testCompareTo() {
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setDataHora(LocalDateTime.now().minusDays(1));

        Solicitacao solicitacao2 = new Solicitacao();
        solicitacao2.setDataHora(LocalDateTime.now());

        assertTrue(solicitacao2.compareTo(solicitacao1) > 0);
        assertTrue(solicitacao1.compareTo(solicitacao2) < 0);
    }

    @Test
    public void testCompareToSameDate() {
        LocalDateTime now = LocalDateTime.now();
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setDataHora(now);

        Solicitacao solicitacao2 = new Solicitacao();
        solicitacao2.setDataHora(now);

        assertEquals(0, solicitacao1.compareTo(solicitacao2));
    }
}
