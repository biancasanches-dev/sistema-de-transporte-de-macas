package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.hospital.model.usuario.Maqueiro;
import org.junit.jupiter.api.Test;

public class MaqueiroTest {

    @Test
    public void testMaqueiroRole() {
        Maqueiro maqueiro = new Maqueiro();
        maqueiro.setNome("Carlos");
        maqueiro.setSenha("senha123");

        assertEquals("MAQUEIRO", maqueiro.getRole());
    }
}
