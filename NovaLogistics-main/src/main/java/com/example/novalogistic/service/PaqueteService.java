package com.example.novalogistic.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.novalogistic.DTO.PaqueteDTO;
import com.example.novalogistic.model.Paquete;
import com.example.novalogistic.repository.PaqueteRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    public Paquete guardarPaquetes(Paquete paquete){
        log.info("Guardando Paquete...");
        return paqueteRepository.save(paquete);

    }
    
    public List<Paquete>totalPaquetes(){
        return paqueteRepository.findAll();
    }

    public void eliminarPaquetes(Long id){
       log.info("Intentando eliminar el paquete con ID: {}", id);

        if (!paqueteRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: Paquete no encontrado con el ID: " + id);
        }

        paqueteRepository.deleteById(id);
        log.info("Paquete con ID {} eliminado exitosamente", id);
    }

        
    public PaqueteDTO convertirDTO(Paquete paquete){
        PaqueteDTO dto= new PaqueteDTO();
        dto.setDescripcion(paquete.getDescripcion());
        dto.setPeso_kg(paquete.getPeso_kg());
        dto.setEs_fragil(paquete.getEs_fragil());
        return dto;
    }

    public PaqueteDTO buscarPorId(Long id){
        log.info("Buscando paquete por id..");

        Paquete paquete=paqueteRepository.findById(id)
        .orElseThrow(()->new RuntimeException("paquete no encontrado con el ID:"+id));

        return convertirDTO(paquete);
    }

    public Paquete actualizarPaquete(Long id, Paquete datosNuevos) {
    log.info("Actualizando paquete con ID: {}", id);

     //Buscamos si existe 
    Paquete paqueteExistente = paqueteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se puede actualizar: Paquete no encontrado con ID: " + id));

    paqueteExistente.setDescripcion(datosNuevos.getDescripcion());
    paqueteExistente.setPeso_kg(datosNuevos.getPeso_kg());
    paqueteExistente.setEs_fragil(datosNuevos.getEs_fragil());

    return paqueteRepository.save(paqueteExistente);
    }



}
