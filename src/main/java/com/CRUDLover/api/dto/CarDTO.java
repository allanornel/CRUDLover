package com.CRUDLover.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CarDTO(
        @NotBlank String modelo,

        @NotBlank String fabricante,

        @NotBlank String dataFabricacao,

        @NotBlank double valor,

        @NotBlank int anoModelo) {
}
