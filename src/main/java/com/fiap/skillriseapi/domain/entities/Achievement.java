package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_ACHIEVEMENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "achievement_seq")
    @SequenceGenerator(name = "achievement_seq", sequenceName = "TB_ACHIEVEMENT_ID_SEQ", allocationSize = 1)
    @Column(name = "ACHIEVEMENT_ID")
    private Long achievementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo; // MODULOS, TRILHAS, STREAK, PERFIL, ESPECIAL

    @Column(name = "NOME", nullable = false, length = 200)
    private String nome;

    @Column(name = "DESCRICAO", length = 500)
    private String descricao;

    @Column(name = "ICONE", length = 100)
    private String icone; // Nome do ícone Lucide React

    @Column(name = "XP_GANHO")
    private Integer xpGanho;

    @Column(name = "RARIDADE", length = 20)
    private String raridade; // COMUM, RARO, EPICO, LENDARIO

    @Column(name = "DESBLOQUEADO_EM", nullable = false)
    private LocalDate desbloqueadoEm;

    @PrePersist
    protected void onCreate() {
        if (desbloqueadoEm == null) {
            desbloqueadoEm = LocalDate.now();
        }
        if (raridade == null) {
            raridade = "COMUM";
        }
        if (xpGanho == null) {
            xpGanho = 0;
        }
    }
}
