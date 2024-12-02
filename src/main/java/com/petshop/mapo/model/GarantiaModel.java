package com.petshop.mapo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "Nombre must not be blank")
    @NotNull(message = "Nombre must not be null")
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    @NotBlank(message = "Descripcion must not be blank")
    @NotNull(message = "Descripción must not be null")
    private String descripcion;

    @Column(name = "fecha_entrega_cliente", nullable = false)
    @Min(value = 0, message = "Fecha de entrega cliente must be non-negative") // Ensure non-negative values
    private int fechaEntregaCliente;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    @NotNull(message = "Producto must not be null")
    private ProductosModel productosModel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "venta_id")
    @NotNull(message = "Venta must not be null")
    private VentaModel ventaModel;
}
