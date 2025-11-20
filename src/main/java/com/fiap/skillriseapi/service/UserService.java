package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.user.UserResponseDTO;
import com.fiap.skillriseapi.domain.dto.user.UserStatsResponseDTO;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final InscricaoRepository inscricaoRepository;
    private final ProgressoRepository progressoRepository;
    private final CertificadoRepository certificadoRepository;
    private final AchievementRepository achievementRepository;

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return mapToDTO(user);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void addXPToUser(Long userId, int xp) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        
        user.addXP(xp);
        userRepository.save(user);
        log.info("Adicionado {} XP ao usuário {}", xp, userId);
    }

    @Transactional
    public void updateUserStreak(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        
        user.updateStreak();
        userRepository.save(user);
    }

    public UserStatsResponseDTO getUserStats(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Long totalInscricoes = inscricaoRepository.countByUser_UserId(userId);
        Long trilhasCompletas = inscricaoRepository.countByUser_UserIdAndDataConclusaoIsNotNull(userId);
        Long modulosCompletos = progressoRepository.countByInscricao_User_UserIdAndPercentage(userId, new java.math.BigDecimal("100"));
        Long totalCertificados = certificadoRepository.countByUser_UserId(userId);
        Long totalAchievements = achievementRepository.countByUser_UserId(userId);

        double taxaConclusao = totalInscricoes > 0 
            ? (trilhasCompletas * 100.0) / totalInscricoes 
            : 0.0;

        int xpProximoLevel = ((user.getLevel()) * 500) - user.getXp();

        return UserStatsResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .xp(user.getXp())
                .level(user.getLevel())
                .xpProximoLevel(xpProximoLevel)
                .streakDias(user.getStreakDias())
                .ultimoAcesso(user.getUltimoAcesso())
                .totalInscricoes(totalInscricoes)
                .trilhasCompletas(trilhasCompletas)
                .modulosCompletos(modulosCompletos)
                .totalCertificados(totalCertificados)
                .totalAchievements(totalAchievements)
                .taxaConclusao(taxaConclusao)
                .build();
    }

    private UserResponseDTO mapToDTO(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .role(user.getRole().name())
                .createdAt(user.getCreatedAt())
                .xp(user.getXp())
                .level(user.getLevel())
                .streakDias(user.getStreakDias())
                .ultimoAcesso(user.getUltimoAcesso())
                .build();
    }
}
