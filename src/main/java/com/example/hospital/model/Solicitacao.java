package com.example.hospital.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Solicitacao implements Comparable<Solicitacao> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Maqueiro maqueiro;

    private String origem;
    private String destino;
    private Prioridade prioridade;
    private Status status;
    private LocalDateTime dataHora = LocalDateTime.now();
    private boolean isAceita;

    public Solicitacao() {
    }

    @Override
    public int compareTo(Solicitacao outraSolicitacao) {
        return outraSolicitacao.dataHora.compareTo(this.dataHora);
    }

    public long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Maqueiro getMaqueiro() {
        return maqueiro;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public boolean isAceita() {
        return isAceita;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMaqueiro(Maqueiro maqueiro) {
        this.maqueiro = maqueiro;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setStatus(int status) {
        this.status = Status.getStatus(status);
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = Prioridade.getPrioridade(prioridade);
    }

    public void setAceita( Maqueiro maqueiro) {
        this.isAceita = true;
        this.maqueiro = maqueiro;
    }

    public void setRecusada(Maqueiro maqueiro) {
        this.isAceita = false;
        this.maqueiro = maqueiro;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

