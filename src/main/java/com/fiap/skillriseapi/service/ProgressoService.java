package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.progresso.ProgressoResponseDTO;
import com.fiap.skillriseapi.domain.dto.progresso.ProgressoUpdateDTO;
import com.fiap.skillriseapi.domain.entities.Inscricao;
import com.fiap.skillriseapi.domain.entities.Modulo;
import com.fiap.skillriseapi.domain.entities.Progresso;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.InscricaoRepository;
import com.fiap.skillriseapi.repositories.ModuloRepository;
import com.fiap.skillriseapi.repositories.ProgressoRepository;
import com.fiap.skillriseapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProgressoService {

    private final ProgressoRepository progressoRepository;
    private final InscricaoRepository inscricaoRepository;
    private final ModuloRepository moduloRepository;
    private final UserRepository userRepository;
    private final AchievementService achievementService;
    private final InscricaoService inscricaoService;

    @Transactional
    public ProgressoResponseDTO updateProgress(Long inscricaoId, Long moduloId, ProgressoUpdateDTO request) {
        Inscricao inscricao = inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada"));

        Modulo modulo = moduloRepository.findById(moduloId)
                .orElseThrow(() -> new ResourceNotFoundException("Módulo não encontrado"));

        Progresso progresso = progressoRepository
                .findByInscricao_InscricaoIdAndModulo_ModuloId(inscricaoId, moduloId)
                .orElse(Progresso.builder()
                        .inscricao(inscricao)
                        .modulo(modulo)
                        .build());

        BigDecimal percentageAnterior = progresso.getPercentage() != null ? progresso.getPercentage() : BigDecimal.ZERO;
        progresso.setPercentage(request.getPercentage());
        progresso.setLastUpdated(LocalDate.now());

        progresso = progressoRepository.save(progresso);

        if (percentageAnterior.compareTo(BigDecimal.valueOf(100)) < 0
                && request.getPercentage().compareTo(BigDecimal.valueOf(100)) == 0) {
            
            User user = inscricao.getUser();
            
            user.addXP(50);
            user.updateStreak();
            userRepository.save(user);
            
            log.info("Módulo {} completado pelo usuário {}", moduloId, user.getUserId());
            
            achievementService.verificarNovasConquistas(user.getUserId());
            
            inscricaoService.verificarConclusaoTotal(inscricaoId);
        }

        return mapToDTO(progresso);
    }

    public List<ProgressoResponseDTO> findByInscricaoId(Long inscricaoId) {
        return progressoRepository.findByInscricao_InscricaoId(inscricaoId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProgressoResponseDTO mapToDTO(Progresso progresso) {
        return ProgressoResponseDTO.builder()
                .progressoId(progresso.getProgressoId())
                .inscricaoId(progresso.getInscricao().getInscricaoId())
                .moduloId(progresso.getModulo().getModuloId())
                .moduloTitle(progresso.getModulo().getTitle())
                .percentage(progresso.getPercentage())
                .lastUpdated(progresso.getLastUpdated())
                .completedAt(progresso.getCompletedAt())
                .build();
    }
}
