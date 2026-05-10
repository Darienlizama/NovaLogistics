package com.example.novalogistic.DTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SeguimientoDTO {
    private Long id;
    private String numeroGuia; 
    private String estado;
    private String ubicacion;
    private LocalDateTime fecha_hora;

}


