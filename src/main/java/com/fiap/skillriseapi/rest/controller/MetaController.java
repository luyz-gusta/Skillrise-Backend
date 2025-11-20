package com.fiap.skillriseapi.rest.controller;

import com.fiap.skillriseapi.domain.dto.meta.MetaRequestDTO;
import com.fiap.skillriseapi.domain.dto.meta.MetaResponseDTO;
import com.fiap.skillriseapi.service.MetaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/metas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MetaController {

    private final MetaService metaService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MetaResponseDTO>> listarPorUsuario(@PathVariable Long userId) {
        List<MetaResponseDTO> metas = metaService.listarPorUsuario(userId);
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/user/{userId}/ativas")
    public ResponseEntity<List<MetaResponseDTO>> listarAtivas(@PathVariable Long userId) {
        List<MetaResponseDTO> metas = metaService.listarAtivas(userId);
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/{metaId}")
    public ResponseEntity<MetaResponseDTO> buscarPorId(@PathVariable Long metaId) {
        MetaResponseDTO meta = metaService.buscarPorId(metaId);
        return ResponseEntity.ok(meta);
    }

    @PostMapping
    public ResponseEntity<MetaResponseDTO> criar(@Valid @RequestBody MetaRequestDTO request) {
        MetaResponseDTO meta = metaService.criar(request);
        return ResponseEntity.ok(meta);
    }

    @PutMapping("/{metaId}")
    public ResponseEntity<MetaResponseDTO> atualizar(
            @PathVariable Long metaId,
            @Valid @RequestBody MetaRequestDTO request) {
        MetaResponseDTO meta = metaService.atualizar(metaId, request);
        return ResponseEntity.ok(meta);
    }

    @PutMapping("/{metaId}/progresso")
    public ResponseEntity<MetaResponseDTO> atualizarProgresso(
            @PathVariable Long metaId,
            @RequestBody Map<String, Integer> body) {
        Integer incremento = body.get("incremento");
        MetaResponseDTO meta = metaService.atualizarProgresso(metaId, incremento);
        return ResponseEntity.ok(meta);
    }

    @DeleteMapping("/{metaId}")
    public ResponseEntity<Void> deletar(@PathVariable Long metaId) {
        metaService.deletar(metaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/count-ativas")
    public ResponseEntity<Long> contarAtivas(@PathVariable Long userId) {
        Long count = metaService.contarAtivas(userId);
        return ResponseEntity.ok(count);
    }
}
