package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.meta.MetaRequestDTO;
import com.fiap.skillriseapi.domain.dto.meta.MetaResponseDTO;
import com.fiap.skillriseapi.domain.entities.Meta;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.MetaRepository;
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
public class MetaService {

    private final MetaRepository metaRepository;
    private final UserRepository userRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public MetaResponseDTO criar(MetaRequestDTO request) {
        log.info("Criando meta para usuário: {}", request.getUserId());

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Meta meta = Meta.builder()
                .user(user)
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .tipo(request.getTipo())
                .targetValue(request.getTargetValue())
                .prazo(request.getPrazo())
                .build();

        meta = metaRepository.save(meta);
        return mapToDTO(meta);
    }

    public List<MetaResponseDTO> listarPorUsuario(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return metaRepository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<MetaResponseDTO> listarAtivas(Long userId) {
        return metaRepository.findByUser_UserIdAndStatus(userId, "EM_ANDAMENTO")
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public MetaResponseDTO buscarPorId(Long metaId) {
        Meta meta = metaRepository.findById(metaId)
                .orElseThrow(() -> new ResourceNotFoundException("Meta não encontrada"));
        
        return mapToDTO(meta);
    }

    @Transactional
    public MetaResponseDTO atualizarProgresso(Long metaId, Integer incremento) {
        Meta meta = metaRepository.findById(metaId)
                .orElseThrow(() -> new ResourceNotFoundException("Meta não encontrada"));

        boolean eraEmAndamento = "EM_ANDAMENTO".equals(meta.getStatus());
        
        meta.incrementProgress(incremento);
        meta = metaRepository.save(meta);

        if (eraEmAndamento && "CONCLUIDA".equals(meta.getStatus())) {
            notificacaoService.criarNotificacao(
                    meta.getUser().getUserId(),
                    "Meta Conquistada! 🎯",
                    "Parabéns! Você completou sua meta: " + meta.getTitulo(),
                    "GERAL",
                    "Target",
                    "/dashboard"
            );
            log.info("Meta {} concluída para usuário: {}", metaId, meta.getUser().getUserId());
        }

        return mapToDTO(meta);
    }

    @Transactional
    public MetaResponseDTO atualizar(Long metaId, MetaRequestDTO request) {
        Meta meta = metaRepository.findById(metaId)
                .orElseThrow(() -> new ResourceNotFoundException("Meta não encontrada"));

        meta.setTitulo(request.getTitulo());
        meta.setDescricao(request.getDescricao());
        meta.setTipo(request.getTipo());
        meta.setTargetValue(request.getTargetValue());
        meta.setPrazo(request.getPrazo());

        meta = metaRepository.save(meta);
        return mapToDTO(meta);
    }

    @Transactional
    public void deletar(Long metaId) {
        if (!metaRepository.existsById(metaId)) {
            throw new ResourceNotFoundException("Meta não encontrada");
        }
        metaRepository.deleteById(metaId);
    }

    public Long contarAtivas(Long userId) {
        return metaRepository.countByUser_UserIdAndStatus(userId, "EM_ANDAMENTO");
    }

    private MetaResponseDTO mapToDTO(Meta meta) {
        return MetaResponseDTO.builder()
                .metaId(meta.getMetaId())
                .userId(meta.getUser().getUserId())
                .titulo(meta.getTitulo())
                .descricao(meta.getDescricao())
                .tipo(meta.getTipo())
                .targetValue(meta.getTargetValue())
                .currentValue(meta.getCurrentValue())
                .unidade(meta.getUnidade())
                .progresso(meta.getProgresso())
                .dataInicio(meta.getDataInicio())
                .dataFim(meta.getDataFim())
                .prazo(meta.getPrazo())
                .status(meta.getStatus())
                .build();
    }
}
