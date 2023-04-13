package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Persona;

import java.util.List;

public interface IPersonaService extends ICRUD<Persona, Integer>{
    Page<Persona> findAllPagination(Pageable page);

    List<Persona> searchByDni(String dni);

}
