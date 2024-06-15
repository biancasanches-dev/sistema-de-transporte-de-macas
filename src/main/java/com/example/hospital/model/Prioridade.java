package com.example.hospital.model;

public enum Prioridade {
    ALTA, MEDIA, BAIXA;

    public static Prioridade getPrioridade(int prioridade) {
        switch (prioridade) {
            case 1:
                return ALTA;
            case 2:
                return MEDIA;
            case 3:
                return BAIXA;
            default:
                return null;
        }
    }
}
