package com.example.novalogistic.DTO;

import lombok.Data;

@Data
public class ReclamoDTO {
    private long id;
    private long id_cliente;
    private String detalle_cliente;
    private String titulo;
    private boolean estado_reclamo;
}
