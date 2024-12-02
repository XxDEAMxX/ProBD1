package com.petshop.mapo.model.detalleVenta;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.VentaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "detalleVentaModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaModel {
    @EmbeddedId
    private DetalleVentaId id;

    @Column(name = "cantidad_detalle_venta", nullable = false)
    @Min(1) // Ensures cantidad_detalle_venta > 0
    private int cantidad;
    private Double precioUnitario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private ProductosModel productosModel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("ventaId")
    @JoinColumn(name = "venta_id")
    private VentaModel ventaModel;

    public DetalleVentaModel(int cantidad, double precioUnitario, ProductosModel productosModel, VentaModel ventaModel) {
        this.id = new DetalleVentaId(ventaModel.getId(), productosModel.getId());
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.productosModel = productosModel;
        this.ventaModel = ventaModel;
    }
}
