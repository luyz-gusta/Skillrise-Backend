package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_MODULO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulo_seq")
    @SequenceGenerator(name = "modulo_seq", sequenceName = "TB_MODULO_ID_SEQ", allocationSize = 1)
    @Column(name = "MODULO_ID")
    private Long moduloId;

    @Column(name = "TITLE", nullable = false, length = 300)
    private String title;

    @Column(name = "DURATION_MINUTES")
    private Integer durationMinutes;

    @Column(name = "CONTENT_TYPE", length = 50)
    private String contentType;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
    }
}
