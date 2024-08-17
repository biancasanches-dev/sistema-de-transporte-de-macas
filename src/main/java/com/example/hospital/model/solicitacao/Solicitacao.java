package com.example.hospital.model.solicitacao;

import com.example.hospital.model.paciente.Paciente;
import com.example.hospital.model.enums.Prioridade;
import com.example.hospital.model.enums.Status;
import com.example.hospital.model.usuario.Maqueiro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public int compareTo(Solicitacao outraSolicitacao) {
        return outraSolicitacao.dataHora.compareTo(this.dataHora);
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
}

