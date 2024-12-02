package com.petshop.mapo.model.productosProveedores;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProveedoresModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "ID must not be null")
    private ProductosProveedoresId id;

    @Column(name = "precio", nullable = false)
    @NotNull(message = "Precio must not be null")
    @Min(value = 0, message = "Precio must be non-negative")
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
    @NotNull(message = "Proveedor must not be null")
    private ProveedoresModel proveedoresModel;

    // Foreign key to PRODUCTOS
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id", nullable = false)
    @NotNull(message = "Producto must not be null")
    private ProductosModel productosModel;
}
