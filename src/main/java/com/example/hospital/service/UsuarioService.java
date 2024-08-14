package com.example.hospital.service;

import com.example.hospital.model.usuario.Usuario;

public interface UsuarioService {
    Usuario getUsuarioPorNome(String usuario);
    Usuario saveUsuario(Usuario usuario);
    boolean autenticarUsuario(String nome, String senha);
    void deleteUsuario(Long id);
}
