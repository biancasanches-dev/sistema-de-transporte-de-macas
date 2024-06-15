package com.example.hospital.model;

import java.util.Comparator;

public class SolicitacaoPrioridadeComparator implements Comparator<Solicitacao> {
    @Override
    public int compare(Solicitacao s1, Solicitacao s2) {
        if (s1.getPrioridade() == null || s2.getPrioridade() == null) {
            throw new IllegalArgumentException("Prioridade cannot be null");
        }
        return s1.getPrioridade().compareTo(s2.getPrioridade());
    }
}
