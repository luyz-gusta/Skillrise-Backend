package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.trilha.TrilhaRequestDTO;
import com.fiap.skillriseapi.domain.dto.trilha.TrilhaResponseDTO;
import com.fiap.skillriseapi.domain.entities.Trilha;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.TrilhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    public List<TrilhaResponseDTO> findAll() {
        return trilhaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TrilhaResponseDTO findById(Long id) {
        Trilha trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));
        return mapToDTO(trilha);
    }

    public TrilhaResponseDTO create(TrilhaRequestDTO request) {
        Trilha trilha = Trilha.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .difficulty(request.getDifficulty())
                .durationHours(request.getDurationHours())
                .imageUrl(request.getImageUrl())
                .build();
        trilha = trilhaRepository.save(trilha);
        return mapToDTO(trilha);
    }

    public TrilhaResponseDTO update(Long id, TrilhaRequestDTO request) {
        Trilha trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));

        trilha.setTitle(request.getTitle());
        trilha.setDescription(request.getDescription());
        trilha.setDifficulty(request.getDifficulty());
        trilha.setDurationHours(request.getDurationHours());
        trilha.setImageUrl(request.getImageUrl());
        trilha = trilhaRepository.save(trilha);

        return mapToDTO(trilha);
    }

    public void delete(Long id) {
        if (!trilhaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Trilha não encontrada");
        }
        trilhaRepository.deleteById(id);
    }

    private TrilhaResponseDTO mapToDTO(Trilha trilha) {
        return TrilhaResponseDTO.builder()
                .trilhaId(trilha.getTrilhaId())
                .title(trilha.getTitle())
                .description(trilha.getDescription())
                .difficulty(trilha.getDifficulty())
                .durationHours(trilha.getDurationHours())
                .imageUrl(trilha.getImageUrl())
                .createdAt(trilha.getCreatedAt())
                .build();
    }
}
