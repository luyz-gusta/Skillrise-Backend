package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.modulo.ModuloRequestDTO;
import com.fiap.skillriseapi.domain.dto.modulo.ModuloResponseDTO;
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

@Tag(name = "Módulos", description = "Gerenciamento de módulos de trilhas")
@ApiResponseInternalServerError
public interface ModuloControllerSpecs {

    @Operation(summary = "Listar todos os módulos", description = "Retorna lista com todos os módulos disponíveis")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ModuloResponseDTO>> findAll();

    @Operation(summary = "Buscar módulo por ID", description = "Retorna os detalhes de um módulo específico")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> findById(@PathVariable Long id);

    @Operation(summary = "Criar novo módulo", description = "Cria um novo módulo em uma trilha (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> create(@Valid @RequestBody ModuloRequestDTO request);

    @Operation(summary = "Atualizar módulo", description = "Atualiza os dados de um módulo existente (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ModuloResponseDTO>> update(@PathVariable Long id, @Valid @RequestBody ModuloRequestDTO request);

    @Operation(summary = "Deletar módulo", description = "Remove um módulo do sistema (apenas Admin)")
    @SecurityRequirement(name = "bearer-jwt")
    @ApiResponseNotFound
    @ApiResponseUnauthorized
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id);
}
