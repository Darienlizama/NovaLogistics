package com.example.novalogistic.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registros")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;

    //Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @NotNull(message = "El usuario es obligatorio")
    private Cliente usuario; 

    private boolean accion_realizada;

    @Column(name = "fecha_evento")
    private LocalDateTime fecha_evento;

    @PrePersist
    protected void onCreate() {
        this.fecha_evento = LocalDateTime.now();
    }
}