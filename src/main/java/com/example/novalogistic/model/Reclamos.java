package com.example.novalogistic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "reclamos")
public class Reclamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "el id no debe estar vacio")
    private long id_cliente;


    @NotBlank(message = "el titulo no debe estar vacio ")
    private String titulo;

    @NotBlank(message = "el detalle no debe estar vacio")
    private String detalle_cliente;

    private boolean estado_reclamo;
}
