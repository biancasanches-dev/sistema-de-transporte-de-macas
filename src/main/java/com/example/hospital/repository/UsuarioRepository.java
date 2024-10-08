package com.example.hospital.repository;

import com.example.hospital.model.usuario.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    Usuario findFirstByUsername(String username);
}
