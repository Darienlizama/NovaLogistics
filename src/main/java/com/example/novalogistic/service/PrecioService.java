package com.example.novalogistic.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.novalogistic.DTO.PrecioDTO;
import com.example.novalogistic.model.Precio;
import com.example.novalogistic.repository.PrecioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrecioService 
{
    @Autowired
    private PrecioRepository precioRepository;

    public Precio guardarPrecio(Precio precio)
    {
        log.info("Guardando el precio...");
        return precioRepository.save(precio);
    }
    public List<PrecioDTO> totalPrecios()
    {
        List<Precio> precios = precioRepository.findAll();
        return precios.stream().map(this::convertirADTO).toList();
    }
    public void eliminarPrecio(Integer id)
    {
        //este es un chiste que deje aca mientras, luego lo borramos
        log.info("Intentando eliminar el precio porque la alza ta mala");
        if(!precioRepository.existsById(id))
            {
                throw new RuntimeException("No se puede eliminar el precio, porque el capitalismo gano");
            }
    }

    public Precio actualizarPrecio(Integer id, Precio nuevoPrecio)
    {
        log.info("Actualizando el precio con ID : {}", id);
        Precio precioExistente = precioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se puede actualizar el precio, porque no se ha encontrado con la ID: " + id));
        precioExistente.setPrecioBase(nuevoPrecio.getPrecioBase());
        return precioRepository.save(precioExistente);
    }
    
    public PrecioDTO convertirADTO (Precio precio) 
    {
        PrecioDTO dto = new PrecioDTO();
        dto.setId(precio.getId());
        dto.setPrecio_base(precio.getPrecioBase());
        return dto;
    }   

    public PrecioDTO buscarPorid(Integer id){
        Precio precio= precioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Precio no encontrado con la ID: " + id));

        return convertirADTO(precio);
    }

 

}
