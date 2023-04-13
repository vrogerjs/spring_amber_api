package regionancash.gob.pe.amber.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.amber.model.Desaparecido;

public interface IDesaparecidoService extends ICRUD<Desaparecido, Integer>{
    Page<Desaparecido> findAllByEstado(Pageable page, String estado);
}
