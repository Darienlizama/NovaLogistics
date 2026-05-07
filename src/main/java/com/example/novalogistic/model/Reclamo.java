package com.example.novalogistic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "el id no debe estar vacio")
    @Column(unique = true ,nullable = false)
    private long id_cliente;


    @NotBlank(message = "el titulo no debe estar vacio ")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "el detalle no debe estar vacio")
    @Column(nullable = false)
    private String detalle_cliente;

    @Column(nullable = false)
    private boolean estado_reclamo;
}
