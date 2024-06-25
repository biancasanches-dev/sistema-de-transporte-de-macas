package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProfissionalDeSaudeTest {

    @Test
    public void testProfissionalDeSaudeRole() {
        ProfissionalDeSaude profissional = new ProfissionalDeSaude();
        profissional.setNome("Ana");
        profissional.setSenha("senha456");

        assertEquals("PROFISSIONAL", profissional.getRole());
    }
}
