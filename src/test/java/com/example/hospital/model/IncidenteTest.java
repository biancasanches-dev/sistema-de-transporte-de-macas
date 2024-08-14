package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.example.hospital.model.incidente.Incidente;
import com.example.hospital.model.solicitacao.Solicitacao;
import org.junit.jupiter.api.Test;

public class IncidenteTest {

    @Test
    public void testSetAndGetSolicitacao() {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDataHora(LocalDateTime.now());
        Incidente incidente = new Incidente();
        incidente.setSolicitacao(solicitacao);

        assertEquals(solicitacao, incidente.getSolicitacao());
    }

    @Test
    public void testSetAndGetDescricao() {
        String descricao = "Equipamento quebrado durante o transporte";
        Incidente incidente = new Incidente();
        incidente.setDescricao(descricao);

        assertEquals(descricao, incidente.getDescricao());
    }

    @Test
    public void testCompareTo() {
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setDataHora(LocalDateTime.now().minusDays(1));

        Solicitacao solicitacao2 = new Solicitacao();
        solicitacao2.setDataHora(LocalDateTime.now());

        Incidente incidente1 = new Incidente();
        incidente1.setSolicitacao(solicitacao1);

        Incidente incidente2 = new Incidente();
        incidente2.setSolicitacao(solicitacao2);

        assertTrue(incidente2.compareTo(incidente1) > 0);
        assertTrue(incidente1.compareTo(incidente2) < 0);
    }

    @Test
    public void testCompareToSameDate() {
        LocalDateTime now = LocalDateTime.now();
        Solicitacao solicitacao1 = new Solicitacao();
        solicitacao1.setDataHora(now);

        Solicitacao solicitacao2 = new Solicitacao();
        solicitacao2.setDataHora(now);

        Incidente incidente1 = new Incidente();
        incidente1.setSolicitacao(solicitacao1);

        Incidente incidente2 = new Incidente();
        incidente2.setSolicitacao(solicitacao2);

        assertEquals(0, incidente1.compareTo(incidente2));
    }
}
