package com.example.novalogistic.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sucursal")
public class Sucursal 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="sucursal_id",nullable=false)
    @NotBlank(message = "La dirección no puede estar vacio!")
    private String direccion;

    @NotBlank(message = "La ciudad no puede estar vacio")
    private String ciudad;

    @NotBlank(message = "La comuna no puede estar vacio")
    private String comuna;
    
}
