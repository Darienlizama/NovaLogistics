package com.example.novalogistic.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novalogistic.DTO.SucursalDTO;
import com.example.novalogistic.model.Sucursal;
import com.example.novalogistic.service.SucursalService;

@RestController     
@RequestMapping("/ap1/v1/sucursal")
public class SucursalController 
{
    @Autowired
    private SucursalService sucursalService;
    
    @GetMapping
    public ResponseEntity<List<SucursalDTO>> listarSucursal()
    {
        List<SucursalDTO> sucursales =sucursalService.obtenerSucursal();
        if(sucursales.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(sucursales);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SucursalDTO> buscarSucursalPorId(@PathVariable Integer id)
    {
        try
        {
            SucursalDTO sucursal = sucursalService.SearchById(id);
            return ResponseEntity.ok(sucursal);
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body();
        }
    }
    @PostMapping
    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal)
    {
        Sucursal sucursal= sucursalService.save(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursal);
    } 
    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal)
    {
        try
        {
            Sucursal sucursalActualizado = sucursalService.updateSucursal(id, sucursal);
            return ResponseEntity.ok(sucursalActualizado);
        }
        catch(Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id)
    {
        try
        {
            sucursalService.eliminarSucursal(id);
            return ResponseEntity.noContent().build();
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
