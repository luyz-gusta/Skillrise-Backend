package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_USER_SKILL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_seq")
    @SequenceGenerator(name = "user_skill_seq", sequenceName = "TB_USER_SKILL_ID_SEQ", allocationSize = 1)
    @Column(name = "USER_SKILL_ID")
    private Long userSkillId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKILL_ID", nullable = false)
    private Skill skill;

    @Column(name = "PROFICIENCY_LEVEL")
    private Integer proficiencyLevel;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (proficiencyLevel == null) {
            proficiencyLevel = 0;
        }
    }
}
