package com.example.hospital.service;

import com.example.hospital.model.Incidente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidenteService {

    List<Incidente> getAllIncidentes();
    Incidente getIncidenteById(Long id);
    Incidente saveIncidente(Incidente incidente);
    void deletarIncidente(Long id);
}