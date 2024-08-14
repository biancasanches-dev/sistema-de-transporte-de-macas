package com.example.hospital.service;

import com.example.hospital.model.Paciente;

public interface PacienteService {
    Paciente buscarPaciente(Paciente paciente);
    Paciente salvarPaciente(Paciente paciente);
}
