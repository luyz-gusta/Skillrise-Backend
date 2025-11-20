package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TRILHA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trilha_seq")
    @SequenceGenerator(name = "trilha_seq", sequenceName = "TB_TRILHA_ID_SEQ", allocationSize = 1)
    @Column(name = "TRILHA_ID")
    private Long trilhaId;

    @Column(name = "TITLE", nullable = false, length = 300)
    private String title;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DIFFICULTY", length = 50)
    private String difficulty;

    @Column(name = "DURATION_HOURS", precision = 6, scale = 2)
    private BigDecimal durationHours;

    @Column(name = "IMAGE_URL", length = 500)
    private String imageUrl;

    @Column(name = "TAGS", length = 500)
    private String tags;

    @Column(name = "RATING", precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(name = "TOTAL_AVALIACOES")
    private Integer totalAvaliacoes;

    @Column(name = "CATEGORIA", length = 100)
    private String categoria;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (rating == null) {
            rating = BigDecimal.ZERO;
        }
        if (totalAvaliacoes == null) {
            totalAvaliacoes = 0;
        }
    }

    public void addAvaliacao(int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 5");
        }
        BigDecimal totalPontos = rating.multiply(new BigDecimal(totalAvaliacoes));
        totalPontos = totalPontos.add(new BigDecimal(nota));
        totalAvaliacoes++;
        rating = totalPontos.divide(new BigDecimal(totalAvaliacoes), 2, java.math.RoundingMode.HALF_UP);
    }
}
