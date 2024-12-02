package com.petshop.mapo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "garantiaModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GarantiaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntregaCliente;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private ProductosModel productosModel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "venta_id")
    private VentaModel ventaModel;

    public GarantiaModel(String nombre, String descripcion, LocalDate fechaEntregaCliente, ProductosModel productosModel, VentaModel ventaModel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntregaCliente = fechaEntregaCliente;
        this.productosModel = productosModel;
        this.ventaModel = ventaModel;
    }
}
