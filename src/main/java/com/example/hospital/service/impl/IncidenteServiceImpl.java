package com.example.hospital.service.impl;

import com.example.hospital.model.Incidente;
import com.example.hospital.repository.IncidenteRepository;
import com.example.hospital.service.IncidenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteServiceImpl implements IncidenteService {

    private IncidenteRepository incidenteRepository;

    public IncidenteServiceImpl(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    @Override
    public List<Incidente> getAllIncidentes() {
        return incidenteRepository.findAll();
    }

    @Override
    public Incidente getIncidenteById(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    @Override
    public Incidente saveIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    public void deletarIncidente(Long id) {
        incidenteRepository.deleteById(id);
    }
}
