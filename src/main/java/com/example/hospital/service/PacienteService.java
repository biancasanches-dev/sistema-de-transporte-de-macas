package com.example.hospital.service;

import com.example.hospital.model.Paciente;
import com.example.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {

    Paciente buscarPaciente(Paciente paciente);
    Paciente salvarPaciente(Paciente paciente);
}
