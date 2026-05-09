package com.example.novalogistic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;



@Entity
@Data
@Table(name="precio")
public class Precio 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="precio_id",nullable=false)
    @Min(value = 0, message ="El precio no puede ser negativo")
    @Max(value= 1000000, message= "El precio no puede ser mayor a 1.000.000")
    @Column (unique = false, length = 10)
    private Double precio_base;
    

    
}
