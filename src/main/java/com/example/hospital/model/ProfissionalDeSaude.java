package com.example.hospital.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PROFISSIONAL")
public class ProfissionalDeSaude extends Usuario {
    @Override
    public String setRole() {
        return this.role = "PROFISSIONAL";
    }
}
