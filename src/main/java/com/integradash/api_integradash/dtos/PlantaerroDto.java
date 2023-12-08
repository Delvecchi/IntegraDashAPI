package com.integradash.api_integradash.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlantaerroDto(
        @NotBlank String descricao
) {
}
