package com.example.novalogistic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name="vehiculo") 
public class Vehiculo 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 6, max = 6, message = "La patente debe tener exactamente 6 caracteres ")
    @Column(unique = false, length = 6 )
    private String patente;
    

}

