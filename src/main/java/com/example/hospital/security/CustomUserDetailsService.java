package com.example.hospital.security;

import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByUsername(username);
        if(usuario != null) {
            return new User(
                    usuario.getUsername(),
                    usuario.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(usuario.getRole()))
            );
        } else {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }
    }
}
