package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.hospital.model.usuario.ProfissionalDeSaude;
import org.junit.jupiter.api.Test;

public class ProfissionalDeSaudeTest {

    @Test
    public void testProfissionalDeSaudeRole() {
        ProfissionalDeSaude profissional = new ProfissionalDeSaude();
        profissional.setUsername("Ana");
        profissional.setPassword("senha456");

        assertEquals("PROFISSIONAL", profissional.getRole());
    }
}
