package com.example.hospital.service.impl;

import com.example.hospital.model.Paciente;
import com.example.hospital.repository.PacienteRepository;
import com.example.hospital.service.PacienteService;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente buscarPaciente(Paciente paciente) {
        return pacienteRepository.findByNome(paciente.getNome());
    }

    @Override
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
