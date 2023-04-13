package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Distrito;

public interface IDistritoService extends ICRUD<Distrito, Integer>{
    Page<Distrito> findAllPagination(Pageable page);
}
