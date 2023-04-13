package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Departamento;

public interface IDepartamentoService extends ICRUD<Departamento, Integer>{
    Page<Departamento> findAllPagination(Pageable page);
}
