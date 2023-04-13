package regionancash.gob.pe.amber.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.amber.model.Persona;

import java.util.List;

public interface IPersonaRepository extends IGenericRepo<Persona, Integer>{
    @Query("SELECT p FROM Persona p WHERE p.dni = :dni")
    List<Persona> searchByDni(@Param("dni") String dni);
}
