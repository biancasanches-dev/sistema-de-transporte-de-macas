package com.example.hospital.service.impl;

import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.repository.UsuarioRepository;

import com.example.hospital.service.UsuarioService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario getUsuarioPorNome (String usuario) {
        return usuarioRepository.findByUsername(usuario);
    }

    public Usuario saveUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return usuarioRepository.findByUsername(authentication.getName());
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
