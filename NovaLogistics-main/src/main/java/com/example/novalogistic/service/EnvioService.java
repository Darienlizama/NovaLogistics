package com.example.novalogistic.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.novalogistic.model.Envio;
import com.example.novalogistic.repository.EnvioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public Envio guardarEnvio(Envio envio){
        log.info("Guardando envio...");
        return envioRepository.save(envio);

    }

    public List<Envio>listaEnvios(){
        return envioRepository.findAll();
    }

    public void eliminarEnvio(Long id){
        if(!envioRepository.existsById(id)){
            throw new RuntimeException("No se puede eliminar:Envio no encontrado con el ID: "+id);
        }

        envioRepository.deleteById(id);
        log.info("Envio eliminado con exito");
    
    
    }





}
