package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.dto.modulo.ModuloRequestDTO;
import com.fiap.skillriseapi.domain.dto.modulo.ModuloResponseDTO;
import com.fiap.skillriseapi.infra.responses.ApiResponseBuilder;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.service.ModuloService;
import com.fiap.skillriseapi.specs.ModuloControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/modulos")
public class ModuloController implements ModuloControllerSpecs {

    private final ModuloService moduloService;

    @GetMapping
    public ResponseEntity<ApiListResponse<ModuloResponseDTO>> findAll() {
        return ResponseEntity.ok(ApiResponseBuilder.listSuccess(moduloService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> findById(@PathVariable Long id) {
        ModuloResponseDTO modulo = moduloService.findById(id);
        return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(modulo));
    }

    @GetMapping("/trilha/{trilhaId}")
    public ResponseEntity<ApiListResponse<ModuloResponseDTO>> findByTrilhaId(@PathVariable Long trilhaId) {
        return ResponseEntity.ok(ApiResponseBuilder.listSuccess(moduloService.findByTrilhaId(trilhaId)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> create(@Valid @RequestBody ModuloRequestDTO request) {
        ModuloResponseDTO modulo = moduloService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(modulo));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> update(
            @PathVariable Long id,
            @Valid @RequestBody ModuloRequestDTO request
    ) {
        ModuloResponseDTO modulo = moduloService.update(id, request);
        return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(modulo));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id) {
        moduloService.delete(id);
        return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
    }
}
