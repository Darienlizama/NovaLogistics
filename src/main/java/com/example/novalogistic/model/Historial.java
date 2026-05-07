package com.example.novalogistic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial")
@Data
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de envío es necesario para el historial")
    private Long id_envio;

    @NotBlank(message = "Debe especificar un estado")
    private String estado;

    private String ubicacion;

    private LocalDateTime fecha_hora;

    @PrePersist
    protected void onCreate() {
        this.fecha_hora = LocalDateTime.now();
    }
}
