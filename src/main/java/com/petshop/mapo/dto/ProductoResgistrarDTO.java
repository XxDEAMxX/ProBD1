package com.petshop.mapo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductoResgistrarDTO(
        @NotBlank
        String nombre,
        @NotNull
        @Positive
        double precioCosto,
        @NotNull
        @Positive
        double precioVenta,
        @NotBlank
        String descripcion,
        @NotNull
        @Positive
        int cantidad
) {

}
