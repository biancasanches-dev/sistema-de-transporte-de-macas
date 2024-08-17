package com.example.hospital.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.usuario.Usuario;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testUsuarioEquality() {
        Usuario usuario1 = new Maqueiro();
        usuario1.setId(1L);
        usuario1.setUsername("João");

        Usuario usuario2 = new Maqueiro();
        usuario2.setId(1L);
        usuario2.setUsername("João");

        assertEquals(usuario1, usuario2);
        assertEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    public void testUsuarioInequality() {
        Usuario usuario1 = new Maqueiro();
        usuario1.setId(1L);
        usuario1.setUsername("João");

        Usuario usuario2 = new Maqueiro();
        usuario2.setId(2L);
        usuario2.setUsername("Maria");

        assertNotEquals(usuario1, usuario2);
    }
}
