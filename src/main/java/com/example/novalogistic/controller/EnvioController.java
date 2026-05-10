package com.example.novalogistic.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.novalogistic.DTO.EnvioDTO;
import com.example.novalogistic.model.Envio;
import com.example.novalogistic.service.EnvioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/envio")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @PostMapping
    public ResponseEntity<Envio>guardarEnvio(@Valid@RequestBody Envio envio){
        Envio nuevo=envioService.guardarEnvio(envio);
        return new ResponseEntity<>(nuevo,HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Envio>>listaEnvios(){
        log.info("consultando lista de paquetes");
        List<Envio>envios=envioService.listaEnvios();
        return new ResponseEntity<>(envios,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarEnvio(@PathVariable Long id){
        envioService.eliminarEnvio(id);
        return ResponseEntity.ok("El envío con el ID: " + id + " fue eliminado con éxito");

    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO>buscarPorId(@PathVariable Long id){
        EnvioDTO dto=envioService.buscarPorId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

     // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Envio> actualizar(@PathVariable Long id, @Valid @RequestBody Envio envio) {
        log.info("Petición recibida para actualizar el Envio ID: {}", id);
        Envio actualizado = envioService.actualizarEnvio(id, envio);
        return ResponseEntity.ok(actualizado);
    }


}

