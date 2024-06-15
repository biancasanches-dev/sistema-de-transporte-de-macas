package com.example.hospital.model;

import java.util.List;

public class DashboardData {

    private List<Solicitacao> solicitacoesAbertas;
    private List<Solicitacao> solicitacoesEmAndamento;
    private List<Solicitacao> solicitacoesEncerradas;
    private List<Incidente> incidentes;
    private Solicitacao solicitacao;


    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public List<Solicitacao> getSolicitacoesAbertas() {
        return solicitacoesAbertas;
    }

    public List<Solicitacao> getSolicitacoesEmAndamento() {
        return solicitacoesEmAndamento;
    }

    public List<Solicitacao> getSolicitacoesEncerradas() {
        return solicitacoesEncerradas;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void setSolicitacoesAbertas(List<Solicitacao> solicitacoesAbertas) {
        this.solicitacoesAbertas = solicitacoesAbertas;
    }

    public void setSolicitacoesEmAndamento(List<Solicitacao> solicitacoesEmAndamento) {
        this.solicitacoesEmAndamento = solicitacoesEmAndamento;
    }

    public void setSolicitacoesEncerradas(List<Solicitacao> solicitacoesEncerradas) {
        this.solicitacoesEncerradas = solicitacoesEncerradas;
    }
}
