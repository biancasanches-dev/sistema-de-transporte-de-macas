package com.example.hospital.service;

import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.solicitacao.Solicitacao;

import java.util.List;

public interface SolicitacaoService {
    List<Solicitacao> getAllSolicitacoes();
    Solicitacao getSolicitacaoById(Long id);
    Solicitacao saveSolicitacao(Solicitacao solicitacao);
    List<Solicitacao> getSolicitacoesByStatus(int status);
    List<Solicitacao> getSolicitacoesByStatusList(List<Integer> statusList);
    List<Solicitacao> getSolicitacoesByPrioridade();
    Solicitacao aceitarSolicitacao(Long id, Maqueiro maqueiro);
    Solicitacao recusarSolicitacao(Long id, Maqueiro maqueiro);
    Solicitacao concluirSolicitacao(Long id);
    void deleteSolicitacao(Long id);
}
