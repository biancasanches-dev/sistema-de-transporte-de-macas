package com.example.hospital.model.usuario;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MAQUEIRO")
public class Maqueiro extends Usuario {
    public String setRole() {
        return this.role = "MAQUEIRO";
    }
}
