package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_EMPRESA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
    @SequenceGenerator(name = "empresa_seq", sequenceName = "TB_EMPRESA_ID_SEQ", allocationSize = 1)
    @Column(name = "EMPRESA_ID")
    private Long empresaId;

    @Column(name = "NAME", nullable = false, length = 300)
    private String name;

    @Column(name = "WEBSITE", length = 300)
    private String website;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
    }
}
