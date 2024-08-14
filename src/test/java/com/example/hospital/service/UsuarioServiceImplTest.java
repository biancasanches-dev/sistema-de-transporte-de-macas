package com.example.hospital.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.usuario.ProfissionalDeSaude;
import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.repository.UsuarioRepository;

import com.example.hospital.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    public void testGetUsuarioPorNomeMaqueiro() {
        Usuario maqueiro = new Maqueiro();
        maqueiro.setNome("Carlos");
        when(usuarioRepository.findByNome("Carlos")).thenReturn(maqueiro);

        Usuario encontrado = usuarioService.getUsuarioPorNome("Carlos");

        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNome());
        assertTrue(encontrado instanceof Maqueiro);
        verify(usuarioRepository, times(1)).findByNome("Carlos");
    }

    @Test
    public void testGetUsuarioPorNomeProfissional() {
        Usuario profissional = new ProfissionalDeSaude();
        profissional.setNome("Ana");
        when(usuarioRepository.findByNome("Ana")).thenReturn(profissional);

        Usuario encontrado = usuarioService.getUsuarioPorNome("Ana");

        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNome());
        assertTrue(encontrado instanceof ProfissionalDeSaude);
        verify(usuarioRepository, times(1)).findByNome("Ana");
    }

    @Test
    public void testSaveUsuarioMaqueiro() {
        Usuario maqueiro = new Maqueiro();
        maqueiro.setNome("Carlos");
        when(usuarioRepository.save(maqueiro)).thenReturn(maqueiro);

        Usuario salvo = usuarioService.saveUsuario(maqueiro);

        assertNotNull(salvo);
        assertEquals("Carlos", salvo.getNome());
        assertTrue(salvo instanceof Maqueiro);
        verify(usuarioRepository, times(1)).save(maqueiro);
    }

    @Test
    public void testSaveUsuarioProfissional() {
        Usuario profissional = new ProfissionalDeSaude();
        profissional.setNome("Ana");
        when(usuarioRepository.save(profissional)).thenReturn(profissional);

        Usuario salvo = usuarioService.saveUsuario(profissional);

        assertNotNull(salvo);
        assertEquals("Ana", salvo.getNome());
        assertTrue(salvo instanceof ProfissionalDeSaude);
        verify(usuarioRepository, times(1)).save(profissional);
    }

    @Test
    public void testAutenticarUsuarioMaqueiro() {
        Usuario maqueiro = new Maqueiro();
        maqueiro.setNome("Carlos");
        maqueiro.setSenha("senha123");
        when(usuarioRepository.findByNome("Carlos")).thenReturn(maqueiro);

        boolean autenticado = usuarioService.autenticarUsuario("Carlos", "senha123");

        assertTrue(autenticado);
        verify(usuarioRepository, times(1)).findByNome("Carlos");
    }

    @Test
    public void testAutenticarUsuarioProfissional() {
        Usuario profissional = new ProfissionalDeSaude();
        profissional.setNome("Ana");
        profissional.setSenha("senha456");
        when(usuarioRepository.findByNome("Ana")).thenReturn(profissional);

        boolean autenticado = usuarioService.autenticarUsuario("Ana", "senha456");

        assertTrue(autenticado);
        verify(usuarioRepository, times(1)).findByNome("Ana");
    }

    @Test
    public void testDeleteUsuario() {
        Long id = 1L;

        usuarioService.deleteUsuario(id);

        verify(usuarioRepository, times(1)).deleteById(id);
    }
}
