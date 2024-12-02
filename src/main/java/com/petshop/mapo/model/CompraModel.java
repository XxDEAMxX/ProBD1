package com.petshop.mapo.model;

import com.petshop.mapo.model.productosCompras.ProductosComprasModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "compraModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @NotNull(message = "Fecha must not be null")
    private LocalDate fecha;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<ProductosComprasModel> productosComprasList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id")
    @NotNull(message = "Proveedor must not be null")
    private ProveedoresModel proveedoresModel;
}
