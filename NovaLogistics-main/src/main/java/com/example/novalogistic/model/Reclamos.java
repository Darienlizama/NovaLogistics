package com.example.novalogistic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reclamos")
public class Reclamos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // CORRECCIÓN: Relación con la entidad Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    @NotBlank(message = "el titulo no debe estar vacio")
    private String titulo;

    @NotBlank(message = "el detalle no debe estar vacio")
    @Column(name = "detalle_cliente")
    private String detalleCliente;

    @Column(name = "estado_reclamo")
    private boolean estadoReclamo;
}