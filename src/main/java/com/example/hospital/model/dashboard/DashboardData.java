package com.example.hospital.model.dashboard;

import com.example.hospital.model.incidente.Incidente;
import com.example.hospital.model.solicitacao.Solicitacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardData {

    private List<Solicitacao> solicitacoesAbertas;
    private List<Solicitacao> solicitacoesEmAndamento;
    private List<Solicitacao> solicitacoesEncerradas;
    private List<Incidente> incidentes;
    private Solicitacao solicitacao;

}
