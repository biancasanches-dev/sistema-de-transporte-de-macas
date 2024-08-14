package com.example.hospital.service;

import com.example.hospital.model.paciente.Paciente;

public interface PacienteService {
    Paciente buscarPaciente(Paciente paciente);
    Paciente salvarPaciente(Paciente paciente);
}
