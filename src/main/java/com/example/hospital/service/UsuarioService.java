package com.example.hospital.service;

import com.example.hospital.model.Usuario;
import com.example.hospital.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
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
