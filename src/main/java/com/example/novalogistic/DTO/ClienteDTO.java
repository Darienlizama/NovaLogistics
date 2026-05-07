package com.example.novalogistic.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String categoriaCliente;
}