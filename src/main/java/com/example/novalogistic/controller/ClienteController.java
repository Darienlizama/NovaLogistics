package com.example.novalogistic.controller;
import com.example.novalogistic.DTO.ClienteDTO;
import com.example.novalogistic.model.Cliente;
import com.example.novalogistic.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Slf4j 
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    // guardar
    @PostMapping("/registrar")
    public ResponseEntity<Cliente> crearCliente(@Valid @RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.guardarCliente(cliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    //listar
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        log.info("Consultando lista completa de clientes");
        List<Cliente> clientes = clienteService.obtenerTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }


    //buscarporid
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerDatos(@PathVariable Long id) {
        ClienteDTO dto = clienteService.obtenerClientePorId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}