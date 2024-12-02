package com.petshop.mapo.dto;

import com.petshop.mapo.model.GarantiaModel;
import com.petshop.mapo.model.VentaModel;
import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;

import java.time.LocalDate;
import java.util.List;

public record VentaRegistrarDTO(
        VentaModel.MetodoPagoEnum metodoPago,
        LocalDate fecha,
        Double total,
        VentaModel.EstadoVentaEnum estado,
        Long cliente_id,
        Long empleado_id,
        List<DetalleVentaRegistarDTO> detalleVentaModelList
) {

}
