package com.petshop.mapo.model.detalleVenta;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaId implements Serializable {

    @Column(name = "venta_id")
    private Long ventaId;

    @Column(name = "producto_id")
    private Long productoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleVentaId that = (DetalleVentaId) o;

        if (!Objects.equals(ventaId, that.ventaId)) return false;
        return Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        int result = ventaId != null ? ventaId.hashCode() : 0;
        result = 31 * result + (productoId != null ? productoId.hashCode() : 0);
        return result;
    }
}
