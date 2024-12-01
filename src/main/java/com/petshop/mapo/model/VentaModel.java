package com.petshop.mapo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "ventas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPagoEnum metodoPago;

    @Column(name = "fecha_venta", nullable = false)
    @NotNull
    private LocalDate fecha;

    @Column(name = "total_venta", nullable = false)
    @Min(0) // Ensures total_venta is non-negative at the application level
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_venta", nullable = false)
    private EstadoVentaEnum estado;

    // Foreign key to PERSONAS (cliente)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaModel cliente;

    // Foreign key to PERSONAS (empleado)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id")
    private PersonaModel empleado;

    // One-to-Many relationships
    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleVentaModel> detalleVentaModelList;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GarantiaModel> garantiaModelList;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosModel> productosModelList;

    public enum EstadoVentaEnum {
        PENDIENTE,
        PAGADA,
        CANCELADA,
    }

    public enum MetodoPagoEnum {
        EFECTIVO,
        TRANSFERENCIA,
        TARJETA,
    }

}


