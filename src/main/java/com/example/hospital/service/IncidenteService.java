package com.example.hospital.service;

import com.example.hospital.model.incidente.Incidente;

import java.util.List;

public interface IncidenteService {

    List<Incidente> getAllIncidentes();
    Incidente getIncidenteById(Long id);
    Incidente saveIncidente(Incidente incidente);
    void deletarIncidente(Long id);
}