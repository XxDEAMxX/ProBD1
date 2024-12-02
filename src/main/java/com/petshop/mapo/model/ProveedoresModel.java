package com.petshop.mapo.model;

import com.petshop.mapo.model.productosProveedores.ProductosProveedoresModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "proveedoresModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "proveedoresModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CompraModel> compraModelList;

    @OneToMany(mappedBy = "proveedoresModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosProveedoresModel> productosProveedoresModelsList;
}
