package com.petshop.mapo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "personaModel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String telefono;
    @Column(unique = true)
    private String email;
    private String direccion;
    private Double capacidadCredito;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VentaModel> clienteVentaModelsList;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VentaModel> EmpleadoVentaModelsList;
}
