package com.example.novalogistic.repository;
import com.example.novalogistic.model.Envio;
import com.example.novalogistic.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long > {
    // Buscar historial por el objeto envio
    List<Seguimiento> findByEnvio(Envio envio);

    // Buscar historial directamente por el ID del envío (Muy útil)
    List<Seguimiento> findByEnvioId(Long envioId);
}
