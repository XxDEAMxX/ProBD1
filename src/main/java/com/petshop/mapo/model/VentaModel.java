package com.petshop.mapo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "ventaModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MetodoPagoEnum metodoPago;
    private LocalDate fecha;
    private Double total;
    @Enumerated(EnumType.STRING)
    private EstadoVentaEnum estado;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleVentaModel> detalleVentaModelList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id")
    private PersonaModel empleado;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private PersonaModel cliente;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GarantiaModel> garantiaModelList;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosModel> productosModelList;
}
