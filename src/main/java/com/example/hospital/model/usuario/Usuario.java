package com.example.hospital.model.usuario;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    private String senha;

    protected String role = setRole();

    public Usuario() {}

    public String setRole() {
        return this.role = "USER";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id && Objects.equals(getNome(), usuario.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getNome());
    }
}
