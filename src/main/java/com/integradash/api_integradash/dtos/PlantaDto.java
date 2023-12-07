package com.integradash.api_integradash.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlantaDto(
        @NotBlank String nomeplanta,

        @NotBlank String endereco_planta
) {
}
