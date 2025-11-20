package com.fiap.skillriseapi.infra.responses;

import com.fiap.skillriseapi.infra.responses.details.ApiListResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiMessageResponse;
import com.fiap.skillriseapi.infra.responses.details.ApiSingleResponse;

import java.util.List;

public class ApiResponseBuilder {

    public static <T> ApiListResponse<T> listSuccess(List<T> data) {
        return ApiListResponse.<T>builder()
                .status(200)
                .message("Requisição bem sucedida!")
                .data(data)
                .build();
    }

    public static <T> ApiSingleResponse<T> singleSuccess(T data) {
        return ApiSingleResponse.<T>builder()
                .status(200)
                .message("Requisição bem sucedida!")
                .data(data)
                .build();
    }

    public static <T> ApiSingleResponse<T> singleCreate(T data) {
        return ApiSingleResponse.<T>builder()
                .status(201)
                .message("Item criado com sucesso!")
                .data(data)
                .build();
    }

    public static <T> ApiSingleResponse<T> singleUpdate(T data) {
        return ApiSingleResponse.<T>builder()
                .status(200)
                .message("Item atualizado com sucesso!")
                .data(data)
                .build();
    }

    public static ApiMessageResponse singleDelete() {
        return ApiMessageResponse.builder()
                .status(200)
                .message("Item deletado com sucesso!")
                .build();
    }

    public static ApiMessageResponse message(Integer status, String message) {
        return ApiMessageResponse.builder()
                .status(status)
                .message(message)
                .build();
    }
}
