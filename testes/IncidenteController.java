package com.example.hospital.controller;

import com.example.hospital.model.Incidente;
import com.example.hospital.service.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IncidenteService incidenteService;

    @GetMapping
    public List<Incidente> getAllIncidentes() {
        return incidenteService.getAllIncidentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidente> getIncidenteById(@PathVariable Long id) {
        Incidente incidente = incidenteService.getIncidenteById(id);
        return incidente != null ? ResponseEntity.ok(incidente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Incidente createIncidente(@RequestBody Incidente incidente) {
        return incidenteService.saveIncidente(incidente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncidente(@PathVariable Long id) {
        incidenteService.deleteIncidente(id);
        return ResponseEntity.noContent().build();
    }
}
