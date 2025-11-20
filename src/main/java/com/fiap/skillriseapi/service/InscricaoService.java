package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.inscricao.InscricaoResponseDTO;
import com.fiap.skillriseapi.domain.entities.Inscricao;
import com.fiap.skillriseapi.domain.entities.Trilha;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.BusinessException;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.InscricaoRepository;
import com.fiap.skillriseapi.repositories.ModuloRepository;
import com.fiap.skillriseapi.repositories.ProgressoRepository;
import com.fiap.skillriseapi.repositories.TrilhaRepository;
import com.fiap.skillriseapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final UserRepository userRepository;
    private final TrilhaRepository trilhaRepository;
    private final ModuloRepository moduloRepository;
    private final ProgressoRepository progressoRepository;
    private final CertificadoService certificadoService;

    public InscricaoResponseDTO enrollUser(Long userId, Long trilhaId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Trilha trilha = trilhaRepository.findById(trilhaId)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));

        if (inscricaoRepository.findByUser_UserIdAndTrilha_TrilhaId(userId, trilhaId).isPresent()) {
            throw new BusinessException("Usuário já está inscrito nesta trilha");
        }

        Inscricao inscricao = Inscricao.builder()
                .user(user)
                .trilha(trilha)
                .build();

        inscricao = inscricaoRepository.save(inscricao);
        return mapToDTO(inscricao);
    }

    public List<InscricaoResponseDTO> findByUserId(Long userId) {
        return inscricaoRepository.findByUser_UserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<InscricaoResponseDTO> findByTrilhaId(Long trilhaId) {
        return inscricaoRepository.findByTrilha_TrilhaId(trilhaId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }



    @Transactional
    public void verificarConclusaoTotal(Long inscricaoId) {
        Inscricao inscricao = inscricaoRepository.findById(inscricaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada"));

        if (inscricao.isConcluida()) {
            return;
        }

        Long totalModulos = moduloRepository.countByTrilhaId(inscricao.getTrilha().getTrilhaId());
        
        Long modulosCompletos = progressoRepository.findByInscricao_InscricaoId(inscricaoId)
                .stream()
                .filter(p -> p.getPercentage() >= 100.0)
                .count();

        if (modulosCompletos.equals(totalModulos) && totalModulos > 0) {
            inscricao.marcarComoConcluida();
            inscricaoRepository.save(inscricao);

            User user = inscricao.getUser();
            user.addXP(500);
            userRepository.save(user);

            certificadoService.gerarCertificado(inscricaoId);

            log.info("Trilha {} concluída pelo usuário {}", 
                    inscricao.getTrilha().getTrilhaId(), user.getUserId());
        }
    }

    private InscricaoResponseDTO mapToDTO(Inscricao inscricao) {
        return InscricaoResponseDTO.builder()
                .inscricaoId(inscricao.getInscricaoId())
                .userId(inscricao.getUser().getUserId())
                .trilhaId(inscricao.getTrilha().getTrilhaId())
                .trilhaTitle(inscricao.getTrilha().getTitle())
                .dataInscricao(inscricao.getDataInscricao())
                .dataConclusao(inscricao.getDataConclusao())
                .status(inscricao.getStatus())
                .build();
    }
}
