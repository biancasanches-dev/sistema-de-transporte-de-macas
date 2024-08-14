package com.example.hospital.service.impl;

import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.repository.UsuarioRepository;

import com.example.hospital.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUsuarioPorNome (String usuario) {
        return usuarioRepository.findByNome(usuario);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean autenticarUsuario(String nome, String senha) {
        Usuario usuario = usuarioRepository.findByNome(nome);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
