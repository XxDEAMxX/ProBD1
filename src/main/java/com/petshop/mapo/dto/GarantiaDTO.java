package com.petshop.mapo.dto;

import java.time.LocalDate;

public record GarantiaDTO(
        String descripcion,
        Long venta_id,
        LocalDate fechaEntrada

) {
}
