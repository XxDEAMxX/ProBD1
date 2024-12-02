package com.petshop.mapo.model;

import com.petshop.mapo.model.productosCompras.ProductosComprasModel;
import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
import com.petshop.mapo.model.productosProveedores.ProductosProveedoresModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "productos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nombre_producto", nullable = false, length = 50)
    @NotBlank(message = "Nombre must not be blank") // Ensures a non-blank name
    private String nombre;

    @Column(name = "precio_costo", nullable = false)
    @Min(value = 0, message = "Precio costo must be non-negative")
    private double precioCosto;

    @Column(name = "precio_venta", nullable = false)
    @Min(value = 0, message = "Precio venta must be non-negative")
    private double precioVenta;

    @Column(name = "descripcion_producto", length = 255)
    private String descripcion;

    @Column(name = "cantidad_disponible", nullable = false)
    @Min(value = 0, message = "Cantidad must be non-negative")
    private int cantidad;


    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_producto", nullable = false)
    @NotNull(message = "Categoria must not be null")
    private CategoriaProducto categoria;

    @OneToMany(mappedBy = "productosModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GarantiaModel> garantiaModelList;

    @OneToMany(mappedBy = "productosModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosProveedoresModel> productosProveedoresModelList;


    @OneToMany(mappedBy = "productosModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosComprasModel> productosComprasModelsList;

    @OneToMany(mappedBy = "productosModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleVentaModel> detalleVentaModelList;


    public enum CategoriaProducto {
        FOOD,
        TOYS,
        ACCESSORIES,
        MEDICINE,
    }

}
