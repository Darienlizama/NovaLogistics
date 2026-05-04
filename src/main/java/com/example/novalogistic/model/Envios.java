package com.example.novalogistic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
public class Envios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de guía es obligatorio")
    @Column(unique = true)
    private String numero_guia;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long id_cliente;

    @NotNull(message = "El ID del paquete es obligatorio")
    private Long id_paquete;

    private Double precio;

    private LocalDateTime fecha;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }
}
