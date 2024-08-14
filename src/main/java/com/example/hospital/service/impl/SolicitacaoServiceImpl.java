package com.example.hospital.service.impl;

import com.example.hospital.model.enums.Status;
import com.example.hospital.model.solicitacao.Solicitacao;
import com.example.hospital.model.solicitacao.SolicitacaoPrioridadeComparator;
import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.repository.SolicitacaoRepository;
import com.example.hospital.service.SolicitacaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService {

    private SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoServiceImpl(SolicitacaoRepository solicitacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
    }

    public List<Solicitacao> getAllSolicitacoes() {
        return solicitacaoRepository.findAll();
    }

    public Solicitacao getSolicitacaoById(Long id) {
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public Solicitacao saveSolicitacao(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    public void deleteSolicitacao(Long id) {
        solicitacaoRepository.deleteById(id);
    }

    public List<Solicitacao> getSolicitacoesByStatus(int status) {
        Status statusEnum = Status.getStatus(status);
        if (statusEnum != null) {
            return solicitacaoRepository.findByStatus(statusEnum);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Solicitacao> getSolicitacoesByStatusList(List<Integer> statusList) {
        return solicitacaoRepository.findByStatusIn(statusList);
    }

    public List<Solicitacao> getSolicitacoesByPrioridade() {
        List<Solicitacao> solicitacoes = getSolicitacoesByStatus(0);
        Collections.sort(solicitacoes, new SolicitacaoPrioridadeComparator());
        return solicitacoes;
    }

    public Solicitacao aceitarSolicitacao(Long id , Maqueiro maqueiro) {
        Solicitacao solicitacao = getSolicitacaoById(id);
        if (solicitacao != null) {
            solicitacao.setAceita(maqueiro);
            solicitacao.setDataHora(LocalDateTime.now());
            solicitacao.setStatus(1);
            return solicitacaoRepository.save(solicitacao);
        }
        return null;
    }

    public Solicitacao recusarSolicitacao(Long id, Maqueiro maqueiro) {
        Solicitacao solicitacao = getSolicitacaoById(id);
        if (solicitacao != null) {
            solicitacao.setRecusada(maqueiro);
            solicitacao.setStatus(3);
            solicitacao.setDataHora(LocalDateTime.now());
            return solicitacaoRepository.save(solicitacao);
        }
        return null;
    }

    public Solicitacao concluirSolicitacao(Long id) {
        Solicitacao solicitacao = getSolicitacaoById(id);
        if (solicitacao != null) {
            solicitacao.setStatus(2);
            solicitacao.setDataHora(LocalDateTime.now());
            return solicitacaoRepository.save(solicitacao);
        }
        return null;
    }
}
