package com.petshop.mapo.model;

import com.petshop.mapo.model.productosProveedores.ProductosProveedoresModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "proveedores")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor", nullable = false, updatable = false)
    private long id;

    @Column(name = "nombre_proveedor", nullable = false, length = 50)
    @NotBlank(message = "Nombre must not be blank") // Ensures non-blank name
    private String nombre;

    @Column(name = "telefono_proveedor", nullable = false, length = 20)
    @NotBlank(message = "Telefono must not be blank")
    private String telefono;

    @Column(name = "email_proveedor", nullable = false, unique = true, length = 50)
    @Email(message = "Email must be valid") // Validates email format
    @NotBlank(message = "Email must not be blank")
    private String email;

    @Column(name = "direccion_proveedor", length = 100)
    private String direccion;

    @OneToMany(mappedBy = "proveedoresModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CompraModel> compraModelList;

    @OneToMany(mappedBy = "proveedoresModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosProveedoresModel> productosProveedoresModelsList;
}
