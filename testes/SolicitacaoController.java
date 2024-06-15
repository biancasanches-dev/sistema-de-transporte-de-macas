package com.example.hospital.controller;

import com.example.hospital.model.Solicitacao;
import com.example.hospital.model.Status;
import com.example.hospital.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping
    public List<Solicitacao> getAllSolicitacoes() {
        return solicitacaoService.getAllSolicitacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> getSolicitacaoById(@PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        return solicitacao != null ? ResponseEntity.ok(solicitacao) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Solicitacao createSolicitacao(@RequestBody Solicitacao solicitacao) {
        solicitacao.setStatus(0);
        return solicitacaoService.saveSolicitacao(solicitacao);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Solicitacao> updateStatus(@PathVariable Long id, @RequestParam int status) {
     Solicitacao solicitacao = solicitacaoService.atualizarStatusSolicitacao(id, status);
        return solicitacao != null ? ResponseEntity.ok(solicitacao) : ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public List<Solicitacao> getSolicitacoesByStatus(@PathVariable Status status) {
        return solicitacaoService.getSolicitacoesByStatus(0);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitacao(@PathVariable Long id) {
        solicitacaoService.deleteSolicitacao(id);
        return ResponseEntity.noContent().build();
    }

}
