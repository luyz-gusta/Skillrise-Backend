package com.fiap.skillriseapi.specs;

import com.fiap.skillriseapi.domain.dto.auth.AuthResponseDTO;
import com.fiap.skillriseapi.domain.dto.auth.LoginRequestDTO;
import com.fiap.skillriseapi.domain.dto.auth.RegisterRequestDTO;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;
import com.fiap.skillriseapi.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Autenticação", description = "Endpoints de autenticação e registro")
@ApiResponseInternalServerError
public interface AuthControllerSpecs {

    @Operation(summary = "Registrar novo usuário", description = "Cria uma nova conta de usuário no sistema")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<AuthResponseDTO>> register(@Valid @RequestBody RegisterRequestDTO request);

    @Operation(summary = "Fazer login", description = "Autentica um usuário e retorna token JWT")
    @ApiResponseBadRequest
    @ApiResponseUnauthorized
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<AuthResponseDTO>> login(@Valid @RequestBody LoginRequestDTO request);
}
