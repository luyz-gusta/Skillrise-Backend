package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.modulo.ModuloRequestDTO;
import com.fiap.skillriseapi.domain.dto.modulo.ModuloResponseDTO;
import com.fiap.skillriseapi.domain.entities.Modulo;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.ModuloRepository;
import com.fiap.skillriseapi.repositories.TrilhaModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuloService {

    private final ModuloRepository moduloRepository;
    private final TrilhaModuloRepository trilhaModuloRepository;

    public List<ModuloResponseDTO> findAll() {
        return moduloRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ModuloResponseDTO findById(Long id) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Módulo não encontrado"));
        return mapToDTO(modulo);
    }

    public ModuloResponseDTO create(ModuloRequestDTO request) {
        Modulo modulo = Modulo.builder()
                .title(request.getTitle())
                .durationMinutes(request.getDurationMinutes())
                .contentType(request.getContentType())
                .build();
        modulo = moduloRepository.save(modulo);
        return mapToDTO(modulo);
    }

    public ModuloResponseDTO update(Long id, ModuloRequestDTO request) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Módulo não encontrado"));

        modulo.setTitle(request.getTitle());
        modulo.setDurationMinutes(request.getDurationMinutes());
        modulo.setContentType(request.getContentType());
        modulo = moduloRepository.save(modulo);

        return mapToDTO(modulo);
    }

    public void delete(Long id) {
        if (!moduloRepository.existsById(id)) {
            throw new ResourceNotFoundException("Módulo não encontrado");
        }
        moduloRepository.deleteById(id);
    }

    public List<ModuloResponseDTO> findByTrilhaId(Long trilhaId) {
        return trilhaModuloRepository.findByTrilha_TrilhaIdOrderByModuleOrderAsc(trilhaId).stream()
                .map(trilhaModulo -> mapToDTO(trilhaModulo.getModulo()))
                .collect(Collectors.toList());
    }

    private ModuloResponseDTO mapToDTO(Modulo modulo) {
        return ModuloResponseDTO.builder()
                .moduloId(modulo.getModuloId())
                .title(modulo.getTitle())
                .durationMinutes(modulo.getDurationMinutes())
                .contentType(modulo.getContentType())
                .createdAt(modulo.getCreatedAt())
                .build();
    }
}
