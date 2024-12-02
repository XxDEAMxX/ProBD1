package com.petshop.mapo.model.detalleVenta;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.VentaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "detalleVenta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaModel {
    @EmbeddedId
    @NotNull(message = "ID must not be null")
    private DetalleVentaId id;


    @Column(name = "cantidad_detalle_venta", nullable = false)
    @Min(1) // Ensures cantidad_detalle_venta > 0
    private int cantidad;


    @Column(name = "precio_unitario_venta", nullable = false)
    @NotNull(message = "Precio unitario must not be null")
    @Min(value = 0, message = "Precio unitario must be non-negative") // Ensures precio_unitario_venta >= 0
    private Double precioUnitario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    @NotNull(message = "Producto must not be null")
    private ProductosModel productosModel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("ventaId")
    @JoinColumn(name = "venta_id")
    @NotNull(message = "Producto must not be null")
    private VentaModel ventaModel;

    public DetalleVentaModel(int cantidad, double precioUnitario, ProductosModel productosModel, VentaModel ventaModel) {
        this.id = new DetalleVentaId(ventaModel.getId(), productosModel.getId());
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.productosModel = productosModel;
        this.ventaModel = ventaModel;
    }
}
