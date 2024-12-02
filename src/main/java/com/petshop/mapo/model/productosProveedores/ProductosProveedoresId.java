package com.petshop.mapo.model.productosProveedores;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosProveedoresId implements Serializable {

    @Column(name = "provedor_id")
    private Long proveedorId;

    @Column(name = "producto_id")
    private Long productoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosProveedoresId that = (ProductosProveedoresId) o;

        if (!Objects.equals(proveedorId, that.proveedorId)) return false;
        return Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        int result = proveedorId != null ? proveedorId.hashCode() : 0;
        result = 31 * result + (productoId != null ? productoId.hashCode() : 0);
        return result;
    }
}
