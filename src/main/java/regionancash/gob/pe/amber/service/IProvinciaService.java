package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Provincia;

public interface IProvinciaService extends ICRUD<Provincia, Integer>{
    Page<Provincia> findAllPagination(Pageable page);
}
