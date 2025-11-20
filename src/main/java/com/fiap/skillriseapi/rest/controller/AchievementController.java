package com.fiap.skillriseapi.rest.controller;

import com.fiap.skillriseapi.domain.dto.achievement.AchievementResponseDTO;
import com.fiap.skillriseapi.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AchievementController {

    private final AchievementService achievementService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AchievementResponseDTO>> listarPorUsuario(@PathVariable Long userId) {
        List<AchievementResponseDTO> achievements = achievementService.listarPorUsuario(userId);
        return ResponseEntity.ok(achievements);
    }

    @GetMapping("/user/{userId}/tipo/{tipo}")
    public ResponseEntity<List<AchievementResponseDTO>> listarPorTipo(
            @PathVariable Long userId,
            @PathVariable String tipo) {
        List<AchievementResponseDTO> achievements = achievementService.listarPorTipo(userId, tipo);
        return ResponseEntity.ok(achievements);
    }

    @PostMapping("/verificar/{userId}")
    public ResponseEntity<List<AchievementResponseDTO>> verificarNovasConquistas(@PathVariable Long userId) {
        List<AchievementResponseDTO> novasConquistas = achievementService.verificarNovasConquistas(userId);
        return ResponseEntity.ok(novasConquistas);
    }

    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Long> contarPorUsuario(@PathVariable Long userId) {
        Long total = achievementService.contarPorUsuario(userId);
        return ResponseEntity.ok(total);
    }
}
