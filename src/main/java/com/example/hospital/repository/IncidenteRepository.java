package com.example.hospital.repository;

import com.example.hospital.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
}
