package com.example.novalogistic.model;
import jakarta.persistence.*; 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_gen")
    @SequenceGenerator(name = "clientes_gen", sequenceName = "clientes_seq", allocationSize = 1)
    private Long id;
  

    @NotBlank(message = "El rut no puede estar vacio!")
    @Column(unique = true, nullable = false)
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio!")
    @Column(nullable = false)
    private String apellido;

    @Email(message = "Debe ingresar un correo válido")
    private String correo;

    @NotBlank(message = "el telefono no puede estar vacio!")
    private String telefono;

    @Column(name = "categoria_cliente", nullable = false)
    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoriaCliente = "NORMAL";
}