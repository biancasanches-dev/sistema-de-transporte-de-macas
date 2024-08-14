package com.example.hospital.model.incidente;

import com.example.hospital.model.solicitacao.Solicitacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Incidente implements Comparable<Incidente> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Solicitacao solicitacao;

    private String descricao;

    @Override
    public int compareTo(Incidente incidente) {
        return this.solicitacao.getDataHora().compareTo(incidente.getSolicitacao().getDataHora());
    }
}
