package com.example.novalogistic.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="personal")


public class Personal 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El rut no puede estar vacio!")
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio!")
    private String apellido;
    
    @NotBlank(message ="El cargo no puede estar vacio!")
    private String cargo;   
}
