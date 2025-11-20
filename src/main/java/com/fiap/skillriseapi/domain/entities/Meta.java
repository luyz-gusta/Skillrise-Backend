package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_META")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meta_seq")
    @SequenceGenerator(name = "meta_seq", sequenceName = "TB_META_ID_SEQ", allocationSize = 1)
    @Column(name = "META_ID")
    private Long metaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "TITULO", nullable = false, length = 300)
    private String titulo;

    @Column(name = "DESCRICAO", length = 1000)
    private String descricao;

    @Column(name = "TIPO", length = 50)
    private String tipo; // TRILHA, MODULO, SKILL, XP, TEMPO

    @Column(name = "TARGET_VALUE", nullable = false)
    private Integer targetValue;

    @Column(name = "CURRENT_VALUE")
    private Integer currentValue;

    @Column(name = "UNIDADE", length = 50)
    private String unidade;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @Column(name = "PRAZO")
    private LocalDate prazo;

    @Column(name = "STATUS", length = 50)
    private String status; // EM_ANDAMENTO, CONCLUIDA, CANCELADA

    @PrePersist
    protected void onCreate() {
        if (dataInicio == null) {
            dataInicio = LocalDate.now();
        }
        if (currentValue == null) {
            currentValue = 0;
        }
        if (status == null) {
            status = "EM_ANDAMENTO";
        }
    }

    public double getProgresso() {
        if (targetValue == null || targetValue == 0) return 0.0;
        return (currentValue * 100.0) / targetValue;
    }

    public void incrementProgress(int value) {
        this.currentValue += value;
        if (this.currentValue >= this.targetValue && "EM_ANDAMENTO".equals(this.status)) {
            this.status = "CONCLUIDA";
            this.dataFim = LocalDate.now();
        }
    }
}
