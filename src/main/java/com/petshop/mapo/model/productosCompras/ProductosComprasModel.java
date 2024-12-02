package com.petshop.mapo.model.productosCompras;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.ProductosModel;
import jakarta.persistence.*;
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
    private ProductosComprasId id;
    private Double precioActual;
    private int catidad;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private CompraModel compra;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private ProductosModel productosModel;
}
