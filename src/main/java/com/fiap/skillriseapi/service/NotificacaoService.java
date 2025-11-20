package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.notificacao.NotificacaoRequestDTO;
import com.fiap.skillriseapi.domain.dto.notificacao.NotificacaoResponseDTO;
import com.fiap.skillriseapi.domain.entities.Notificacao;
import com.fiap.skillriseapi.domain.entities.User;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.NotificacaoRepository;
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
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UserRepository userRepository;

    @Transactional
    public NotificacaoResponseDTO criarNotificacao(Long userId, String titulo, String mensagem, String tipo, String icone, String link) {
        log.info("Criando notificação para usuário: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Notificacao notificacao = Notificacao.builder()
                .user(user)
                .titulo(titulo)
                .mensagem(mensagem)
                .tipo(tipo)
                .icone(icone)
                .link(link)
                .build();

        notificacao = notificacaoRepository.save(notificacao);
        return mapToDTO(notificacao);
    }

    @Transactional
    public NotificacaoResponseDTO criar(NotificacaoRequestDTO request) {
        return criarNotificacao(
                request.getUserId(),
                request.getTitulo(),
                request.getMensagem(),
                request.getTipo(),
                request.getIcone(),
                request.getLink()
        );
    }

    public List<NotificacaoResponseDTO> listarPorUsuario(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return notificacaoRepository.findByUser_UserIdOrderByCriadoEmDesc(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<NotificacaoResponseDTO> listarNaoLidas(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return notificacaoRepository.findByUser_UserIdAndLidaOrderByCriadoEmDesc(userId, false)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Long contarNaoLidas(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return notificacaoRepository.countByUser_UserIdAndLida(userId, false);
    }

    @Transactional
    public NotificacaoResponseDTO marcarComoLida(Long notificacaoId) {
        Notificacao notificacao = notificacaoRepository.findById(notificacaoId)
                .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada"));

        notificacao.setLida(true);
        notificacao = notificacaoRepository.save(notificacao);

        return mapToDTO(notificacao);
    }

    @Transactional
    public void marcarTodasComoLidas(Long userId) {
        List<Notificacao> notificacoes = notificacaoRepository
                .findByUser_UserIdAndLidaOrderByCriadoEmDesc(userId, false);

        notificacoes.forEach(n -> n.setLida(true));
        notificacaoRepository.saveAll(notificacoes);

        log.info("Marcadas {} notificações como lidas para usuário: {}", notificacoes.size(), userId);
    }

    @Transactional
    public void deletar(Long notificacaoId) {
        if (!notificacaoRepository.existsById(notificacaoId)) {
            throw new ResourceNotFoundException("Notificação não encontrada");
        }
        notificacaoRepository.deleteById(notificacaoId);
    }

    private NotificacaoResponseDTO mapToDTO(Notificacao notificacao) {
        return NotificacaoResponseDTO.builder()
                .notificacaoId(notificacao.getNotificacaoId())
                .userId(notificacao.getUser().getUserId())
                .titulo(notificacao.getTitulo())
                .mensagem(notificacao.getMensagem())
                .tipo(notificacao.getTipo())
                .icone(notificacao.getIcone())
                .link(notificacao.getLink())
                .lida(notificacao.getLida())
                .criadoEm(notificacao.getCriadoEm())
                .build();
    }
}
