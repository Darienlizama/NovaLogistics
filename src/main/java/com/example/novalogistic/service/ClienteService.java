package com.example.novalogistic.service;

import com.example.novalogistic.DTO.ClienteDTO;
import com.example.novalogistic.model.Cliente;
import com.example.novalogistic.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
    log.info(" Guardando Cliente con RUT:", cliente.getRut());
    
    if(clienteRepository.existsByRut(cliente.getRut())) {
        log.error("Error, el RUT {} ya existe", cliente.getRut());
        throw new RuntimeException("RUT duplicado");
    }
    
    return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodos() {
    return clienteRepository.findAll();
    }


    // Método para convertir a DTO 
    public ClienteDTO convertirADto(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setRut(cliente.getRut());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    public ClienteDTO obtenerClientePorId(Long id) {
    log.info(" Accediendo a datos del cliente ID {}", id);

    Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

    return convertirADto(cliente); 
    }

}