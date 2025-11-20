package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.achievement.AchievementResponseDTO;
import com.fiap.skillriseapi.domain.entities.Achievement;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.AchievementRepository;
import com.fiap.skillriseapi.repositories.UserRepository;
import com.fiap.skillriseapi.repositories.InscricaoRepository;
import com.fiap.skillriseapi.repositories.ProgressoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AchievementService {

    private final AchievementRepository achievementRepository;
    private final UserRepository userRepository;
    private final InscricaoRepository inscricaoRepository;
    private final ProgressoRepository progressoRepository;
    private final NotificacaoService notificacaoService;

    public List<AchievementResponseDTO> listarPorUsuario(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        return achievementRepository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AchievementResponseDTO> listarPorTipo(Long userId, String tipo) {
        return achievementRepository.findByUser_UserIdAndTipo(userId, tipo)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Long contarPorUsuario(Long userId) {
        return achievementRepository.countByUser_UserId(userId);
    }

    @Transactional
    public List<AchievementResponseDTO> verificarNovasConquistas(Long userId) {
        log.info("Verificando novas conquistas para usuário: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        List<Achievement> novasConquistas = new ArrayList<>();

        long modulosCompletos = progressoRepository.countByInscricao_User_UserIdAndPercentage(userId, new java.math.BigDecimal("100"));

        long trilhasCompletas = inscricaoRepository.countByUser_UserIdAndDataConclusaoIsNotNull(userId);

        if (modulosCompletos >= 1 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Primeiro Passo")) {
            novasConquistas.add(concederAchievement(user, "Primeiro Passo", "Completou seu primeiro módulo", "MODULOS", "BookOpen", 50, "COMUM"));
        }

        if (modulosCompletos >= 5 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Estudante Dedicado")) {
            novasConquistas.add(concederAchievement(user, "Estudante Dedicado", "Completou 5 módulos", "MODULOS", "BookMarked", 100, "COMUM"));
        }

        if (modulosCompletos >= 10 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Maratonista")) {
            novasConquistas.add(concederAchievement(user, "Maratonista", "Completou 10 módulos", "MODULOS", "Zap", 150, "RARO"));
        }

        if (modulosCompletos >= 25 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Voraz por Conhecimento")) {
            novasConquistas.add(concederAchievement(user, "Voraz por Conhecimento", "Completou 25 módulos", "MODULOS", "Brain", 300, "RARO"));
        }

        if (trilhasCompletas >= 1 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Explorador")) {
            novasConquistas.add(concederAchievement(user, "Explorador", "Completou sua primeira trilha", "TRILHAS", "Map", 250, "RARO"));
        }

        if (trilhasCompletas >= 3 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Mestre das Trilhas")) {
            novasConquistas.add(concederAchievement(user, "Mestre das Trilhas", "Completou 3 trilhas", "TRILHAS", "Trophy", 500, "EPICO"));
        }

        if (trilhasCompletas >= 5 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Sábio")) {
            novasConquistas.add(concederAchievement(user, "Sábio", "Completou 5 trilhas", "TRILHAS", "GraduationCap", 750, "EPICO"));
        }

        if (trilhasCompletas >= 10 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Lendário")) {
            novasConquistas.add(concederAchievement(user, "Lendário", "Completou 10 trilhas - você é uma lenda!", "TRILHAS", "Crown", 1000, "LENDARIO"));
        }

        if (user.getStreakDias() != null && user.getStreakDias() >= 7 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Sequência de Fogo")) {
            novasConquistas.add(concederAchievement(user, "Sequência de Fogo", "Manteve 7 dias consecutivos de estudo", "STREAK", "Flame", 200, "RARO"));
        }

        if (user.getStreakDias() != null && user.getStreakDias() >= 30 && !achievementRepository.existsByUser_UserIdAndNome(userId, "Imparável")) {
            novasConquistas.add(concederAchievement(user, "Imparável", "Manteve 30 dias consecutivos de estudo!", "STREAK", "TrendingUp", 500, "EPICO"));
        }

        log.info("Encontradas {} novas conquistas para usuário: {}", novasConquistas.size(), userId);

        return novasConquistas.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    protected Achievement concederAchievement(User user, String nome, String descricao, String tipo, String icone, int xp, String raridade) {
        Achievement achievement = Achievement.builder()
                .user(user)
                .nome(nome)
                .descricao(descricao)
                .tipo(tipo)
                .icone(icone)
                .xpGanho(xp)
                .raridade(raridade)
                .build();

        achievement = achievementRepository.save(achievement);

        user.addXP(xp);
        userRepository.save(user);

        notificacaoService.criarNotificacao(
                user.getUserId(),
                "Nova Conquista Desbloqueada! 🏆",
                "Você conquistou: " + nome + " (+" + xp + " XP)",
                "ACHIEVEMENT",
                icone,
                "/perfil"
        );

        log.info("Achievement concedido: {} para usuário: {}", nome, user.getUserId());
        return achievement;
    }

    private AchievementResponseDTO mapToDTO(Achievement achievement) {
        return AchievementResponseDTO.builder()
                .achievementId(achievement.getAchievementId())
                .userId(achievement.getUser().getUserId())
                .tipo(achievement.getTipo())
                .nome(achievement.getNome())
                .descricao(achievement.getDescricao())
                .icone(achievement.getIcone())
                .xpGanho(achievement.getXpGanho())
                .desbloqueadoEm(achievement.getDesbloqueadoEm())
                .raridade(achievement.getRaridade())
                .build();
    }
}
