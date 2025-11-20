package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.skill.SkillRequestDTO;
import com.fiap.skillriseapi.domain.dto.skill.SkillResponseDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.SkillService;
import com.fiap.skillriseapi.specs.SkillControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/skills")
public class SkillController implements SkillControllerSpecs {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<ApiListResponse<SkillResponseDTO>> findAll() {
        try {
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(skillService.findAll()));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<SkillResponseDTO>> findById(@PathVariable Long id) {
        try {
            SkillResponseDTO skill = skillService.findById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(skill));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<SkillResponseDTO>> create(@Valid @RequestBody SkillRequestDTO request) {
        try {
            SkillResponseDTO skill = skillService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(skill));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<SkillResponseDTO>> update(
            @PathVariable Long id,
            @Valid @RequestBody SkillRequestDTO request
    ) {
        try {
            SkillResponseDTO skill = skillService.update(id, request);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(skill));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id) {
        try {
            skillService.delete(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}
