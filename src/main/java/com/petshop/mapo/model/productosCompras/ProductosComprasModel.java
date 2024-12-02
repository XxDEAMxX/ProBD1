package com.petshop.mapo.model.productosCompras;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.ProductosModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "productosComprasModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosComprasModel {
    @EmbeddedId
    @NotNull(message = "ID must not be null")
    private ProductosComprasId id;

    @Column(name = "precio_actual", nullable = false)
    @NotNull(message = "Precio actual must not be null")
    @Min(value = 0, message = "Precio actual must be non-negative")
    private Double precioActual;

    @Column(name = "cantidad", nullable = false)
    @Min(value = 1, message = "Cantidad must be greater than 0")
    private int catidad;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    @NotNull(message = "Compra must not be null")
    private CompraModel compra;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    @NotNull(message = "Producto must not be null")
    private ProductosModel productosModel;
}
