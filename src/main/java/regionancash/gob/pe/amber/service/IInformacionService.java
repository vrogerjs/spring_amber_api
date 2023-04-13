package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Informacion;

public interface IInformacionService extends ICRUD<Informacion, Integer> {
    Page<Informacion> findAllPagination(Pageable page);

}
