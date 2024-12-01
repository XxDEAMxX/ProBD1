package com.petshop.mapo.dto;

import com.petshop.mapo.model.ProductosModel;

public record ProductosResponseDTO(
        Long id,
        String nombre,
        Double precioCosto,
        double precioVenta,
        String descripcion,
        int cantidad

) {

    public ProductosResponseDTO(ProductosModel producto){
        this(producto.getId(), producto.getNombre(), producto.getPrecioCosto(), producto.getPrecioVenta(), producto.getDescripcion(), producto.getCantidad());
    }
}
