package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.trilha.TrilhaRequestDTO;
import com.fiap.skillriseapi.domain.dto.trilha.TrilhaResponseDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Trilhas", description = "Gerenciamento de trilhas de aprendizado")
@ApiResponseInternalServerError
public interface TrilhaControllerSpecs {

    @Operation(summary = "Listar todas as trilhas", description = "Retorna lista com todas as trilhas disponíveis")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<TrilhaResponseDTO>> findAll();

    @Operation(summary = "Buscar trilha por ID", description = "Retorna os detalhes de uma trilha específica")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> findById(@PathVariable Long id);

    @Operation(summary = "Criar nova trilha", description = "Cria uma nova trilha de aprendizado (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> create(@Valid @RequestBody TrilhaRequestDTO request);

    @Operation(summary = "Atualizar trilha", description = "Atualiza os dados de uma trilha existente (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TrilhaResponseDTO>> update(@PathVariable Long id, @Valid @RequestBody TrilhaRequestDTO request);

    @Operation(summary = "Deletar trilha", description = "Remove uma trilha do sistema (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id);
}
