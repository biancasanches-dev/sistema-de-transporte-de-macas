package com.example.hospital.repository;

import com.example.hospital.model.Prioridade;
import com.example.hospital.model.Solicitacao;
import com.example.hospital.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    List<Solicitacao> findByStatus(Status status);
    List<Solicitacao> findByStatusIn(List<Integer> statusList);
}
