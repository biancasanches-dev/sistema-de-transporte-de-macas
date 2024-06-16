package com.example.hospital.service;

import com.example.hospital.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {

    Paciente buscarPaciente(Paciente paciente);
    Paciente salvarPaciente(Paciente paciente);
}
