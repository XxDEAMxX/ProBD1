package com.petshop.mapo.dto;

import java.time.LocalDate;

public record GarantiaDTO(
        String descripcion,
        LocalDate fechaEntrada

) {
}
