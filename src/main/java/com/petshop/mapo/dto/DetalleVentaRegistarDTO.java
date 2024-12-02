package com.petshop.mapo.dto;

import java.util.List;

public record DetalleVentaRegistarDTO(
    Long product_id,
    Double precio_unitario,
    int cantidad,

     GarantiaDTO garantiaModelList
) {
}
