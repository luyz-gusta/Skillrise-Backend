package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.dto.skill.SkillRequestDTO;
import com.fiap.skillriseapi.domain.dto.skill.SkillResponseDTO;
import com.fiap.skillriseapi.domain.entities.Skill;
import com.fiap.skillriseapi.infra.errors.exceptions.ResourceNotFoundException;
import com.fiap.skillriseapi.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public List<SkillResponseDTO> findAll() {
        return skillRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public SkillResponseDTO findById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill não encontrada"));
        return mapToDTO(skill);
    }

    public SkillResponseDTO create(SkillRequestDTO request) {
        Skill skill = Skill.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        skill = skillRepository.save(skill);
        return mapToDTO(skill);
    }

    public SkillResponseDTO update(Long id, SkillRequestDTO request) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill não encontrada"));

        skill.setName(request.getName());
        skill.setDescription(request.getDescription());
        skill = skillRepository.save(skill);

        return mapToDTO(skill);
    }

    public void delete(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Skill não encontrada");
        }
        skillRepository.deleteById(id);
    }

    private SkillResponseDTO mapToDTO(Skill skill) {
        return SkillResponseDTO.builder()
                .skillId(skill.getSkillId())
                .name(skill.getName())
                .description(skill.getDescription())
                .build();
    }
}
