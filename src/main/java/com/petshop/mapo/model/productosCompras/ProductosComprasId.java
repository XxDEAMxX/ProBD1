package com.petshop.mapo.model.productosCompras;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosComprasId implements Serializable {

    @Column(name = "compra_id")
    private Long compraId;

    @Column(name = "producto_id")
    private Long productoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosComprasId that = (ProductosComprasId) o;

        if (!Objects.equals(compraId, that.compraId)) return false;
        return Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        int result = compraId != null ? compraId.hashCode() : 0;
        result = 31 * result + (productoId != null ? productoId.hashCode() : 0);
        return result;
    }
}
