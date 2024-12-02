package com.petshop.mapo.model;

import com.petshop.mapo.model.productosCompras.ProductosComprasModel;
import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
import com.petshop.mapo.model.productosProveedores.ProductosProveedoresModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "productosModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private String descripcion;
    private int cantidad;
    @Enumerated(EnumType.STRING)
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
