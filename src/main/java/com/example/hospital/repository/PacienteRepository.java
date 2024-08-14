package com.example.hospital.repository;

import com.example.hospital.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByNome(String nome);
}
