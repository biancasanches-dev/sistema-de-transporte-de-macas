package com.example.hospital.model;

public enum Status {
    AGUARDANDO_TRANSPORTE, EM_TRANSPORTE, CONCLUIDO, RECUSADA;

    public static Status getStatus(int status) {
        switch (status) {
            case 0:
                return AGUARDANDO_TRANSPORTE;
            case 1:
                return EM_TRANSPORTE;
            case 2:
                return CONCLUIDO;
            case 3:
                return RECUSADA;
            default:
                return null;
        }
    }
}
