package com.example.novalogistic.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="vehiculos")
public class vehiculos 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "La patente no puede estar vacio!")
    @Column(unique = true)
    private String patente;

    @NotBlank(message = "La marca no puede estar vacio")
    private String marca;
    

}
