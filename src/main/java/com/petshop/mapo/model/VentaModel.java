package com.petshop.mapo.model;

import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
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
    @NotNull(message = "Metodo de pago must not be null")
    private MetodoPagoEnum metodoPago;

    @Column(name = "fecha_venta", nullable = false)
    @NotNull(message = "Fecha must not be null")
    private LocalDate fecha;

    @Column(name = "total_venta", nullable = false)
    @NotNull(message = "Total must not be null")
    @Min(value = 0, message = "Total must be non-negative")
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_venta", nullable = false)
    @NotNull(message = "Estado de venta must not be null")
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


