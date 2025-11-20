package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_INSCRICAO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscricao_seq")
    @SequenceGenerator(name = "inscricao_seq", sequenceName = "TB_INSCRICAO_ID_SEQ", allocationSize = 1)
    @Column(name = "INSCRICAO_ID")
    private Long inscricaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRILHA_ID", nullable = false)
    private Trilha trilha;

    @Column(name = "DATA_INSCRICAO", nullable = false)
    private LocalDate dataInscricao;

    @Column(name = "DATA_CONCLUSAO")
    private LocalDate dataConclusao;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @PrePersist
    protected void onCreate() {
        if (dataInscricao == null) {
            dataInscricao = LocalDate.now();
        }
        if (status == null) {
            status = "EM_PROGRESSO";
        }
    }

    public void marcarComoConcluida() {
        if (this.dataConclusao == null) {
            this.dataConclusao = LocalDate.now();
            this.status = "CONCLUIDA";
        }
    }

    public boolean isConcluida() {
        return this.dataConclusao != null;
    }
}
