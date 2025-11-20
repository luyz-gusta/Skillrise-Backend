package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_PROGRESSO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Progresso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progresso_seq")
    @SequenceGenerator(name = "progresso_seq", sequenceName = "TB_PROGRESSO_ID_SEQ", allocationSize = 1)
    @Column(name = "PROGRESSO_ID")
    private Long progressoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSCRICAO_ID", nullable = false)
    private Inscricao inscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULO_ID", nullable = false)
    private Modulo modulo;

    @Column(name = "PERCENTAGE", nullable = false, columnDefinition = "NUMBER(6,2)")
    private Double percentage;

    @Column(name = "COMPLETED_AT")
    private LocalDate completedAt;

    @Column(name = "LAST_UPDATED", nullable = false)
    private LocalDate lastUpdated;

    @PrePersist
    protected void onCreate() {
        if (percentage == null) {
            percentage = 0.0;
        }
        if (lastUpdated == null) {
            lastUpdated = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDate.now();
        if (percentage != null && percentage >= 100.0 && completedAt == null) {
            completedAt = LocalDate.now();
        }
    }
}
