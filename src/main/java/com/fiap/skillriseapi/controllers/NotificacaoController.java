package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.notificacao.NotificacaoRequestDTO;
import com.fiap.skillriseapi.domain.dto.notificacao.NotificacaoResponseDTO;
import com.fiap.skillriseapi.service.NotificacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificacaoResponseDTO>> listarPorUsuario(@PathVariable Long userId) {
        List<NotificacaoResponseDTO> notificacoes = notificacaoService.listarPorUsuario(userId);
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/user/{userId}/nao-lidas")
    public ResponseEntity<List<NotificacaoResponseDTO>> listarNaoLidas(@PathVariable Long userId) {
        List<NotificacaoResponseDTO> notificacoes = notificacaoService.listarNaoLidas(userId);
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Long> contarNaoLidas(@PathVariable Long userId) {
        Long count = notificacaoService.contarNaoLidas(userId);
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{notificacaoId}/ler")
    public ResponseEntity<Void> marcarComoLida(@PathVariable Long notificacaoId) {
        notificacaoService.marcarComoLida(notificacaoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{userId}/ler-todas")
    public ResponseEntity<Void> marcarTodasComoLidas(@PathVariable Long userId) {
        notificacaoService.marcarTodasComoLidas(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<NotificacaoResponseDTO> criar(@Valid @RequestBody NotificacaoRequestDTO request) {
        NotificacaoResponseDTO notificacao = notificacaoService.criar(request);
        return ResponseEntity.ok(notificacao);
    }

    @DeleteMapping("/{notificacaoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long notificacaoId) {
        notificacaoService.deletar(notificacaoId);
        return ResponseEntity.noContent().build();
    }
}
