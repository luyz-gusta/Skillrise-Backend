package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.user.UserResponseDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Usuários", description = "Gerenciamento de usuários")
@SecurityRequirement(name = "bearer-jwt")
@ApiResponseInternalServerError
@ApiResponseUnauthorized
public interface UserControllerSpecs {

    @Operation(summary = "Buscar usuário por ID", description = "Retorna os dados de um usuário específico")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<UserResponseDTO>> findById(@PathVariable Long id);

    @Operation(summary = "Listar todos os usuários", description = "Retorna lista com todos os usuários (apenas Admin)")
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<UserResponseDTO>> findAll();

    @Operation(summary = "Deletar usuário", description = "Remove um usuário do sistema (apenas Admin)")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> delete(@PathVariable Long id);
}
