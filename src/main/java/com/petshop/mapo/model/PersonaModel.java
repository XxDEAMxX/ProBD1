package com.petshop.mapo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "personas", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email_persona")
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    @Column(name = "nombre_persona", nullable = false, length = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido_persona", nullable = false, length = 50)
    @NotNull
    private String apellido;

    @Column(name = "telefono_persona", length = 20)
    private String telefono;

    @Column(name = "email_persona", length = 50, unique = true)
    private String email;

    @Column(name = "direccion_persona", length = 100)
    private String direccion;

    @Column(name = "capacidad_credito")
    @Min(0)
    private Double capacidadCredito;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VentaModel> clienteVentaModelsList;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VentaModel> empleadoVentaModelsList;
}
