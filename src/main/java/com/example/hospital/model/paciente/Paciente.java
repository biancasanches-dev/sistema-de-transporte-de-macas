package com.example.hospital.model.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public Paciente(String nome) {
        this.nome = nome;
    }

    public Paciente() {}

    @Override
    public String toString() {
        return "" + nome + "";
    }
}
