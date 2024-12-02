package com.petshop.mapo.model.productosProveedores;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProveedoresModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "productosProveedoresModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosProveedoresModel {
    @EmbeddedId
    private ProductosProveedoresId id;
    private Double precio;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "provedor_id")
//    private ProveedoresModel proveedoresModel;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "producto_id")
//    private ProductosModel productosModel;

    // Foreign key to PROVEEDORES
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("proveedorId")
    @JoinColumn(name = "provedor_id", nullable = false)
    private ProveedoresModel proveedoresModel;

    // Foreign key to PRODUCTOS
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductosModel productosModel;
}
