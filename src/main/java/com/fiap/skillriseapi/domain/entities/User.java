package com.fiap.skillriseapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_USER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "TB_USER_ID_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 200)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "ROLE", length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @Column(name = "XP")
    private Integer xp;

    @Column(name = "LEVEL_ACCOUNT")
    private Integer level;

    @Column(name = "STREAK_DIAS")
    private Integer streakDias;

    @Column(name = "ULTIMO_ACESSO")
    private LocalDate ultimoAcesso;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (role == null) {
            role = UserRole.USER;
        }
        if (xp == null) {
            xp = 0;
        }
        if (level == null) {
            level = 1;
        }
        if (streakDias == null) {
            streakDias = 0;
        }
    }

    public void addXP(int points) {
        this.xp += points;
        updateLevel();
    }

    private void updateLevel() {
        // XP necessário: Level 1 = 0-499, Level 2 = 500-1499, Level 3 = 1500-2999, etc
        // Fórmula: Level = floor(XP / 500) + 1
        this.level = (this.xp / 500) + 1;
    }

    public void updateStreak() {
        LocalDate hoje = LocalDate.now();
        if (this.ultimoAcesso != null) {
            long diasDiferenca = java.time.temporal.ChronoUnit.DAYS.between(this.ultimoAcesso, hoje);
            if (diasDiferenca == 1) {
                // Dia consecutivo
                this.streakDias++;
            } else if (diasDiferenca > 1) {
                // Quebrou o streak
                this.streakDias = 1;
            }
            // Se diasDiferenca == 0, já acessou hoje, não muda
        } else {
            // Primeiro acesso
            this.streakDias = 1;
        }
        this.ultimoAcesso = hoje;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
