package com.petshop.mapo.dto;

public record DetalleVentaRegistarDTO(
    Long product_id,
    Double precio_unitario,
    int cantidad
) {
}
