package com.example.hospital.model;

import jakarta.persistence.*;

@Entity
public class Incidente implements Comparable<Incidente> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Solicitacao solicitacao;
    private String descricao;

    public long getId() {
        return id;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int compareTo(Incidente incidente) {
        return this.solicitacao.getDataHora().compareTo(incidente.getSolicitacao().getDataHora());
    }
}
