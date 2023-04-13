package regionancash.gob.pe.amber.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import regionancash.gob.pe.amber.model.Desaparecido;

public interface IDesaparecidoRepository extends IGenericRepo<Desaparecido, Integer> {
    @Query("SELECT d FROM Desaparecido d WHERE (:estado IS NULL OR d.estado=:estado)")
    Page findAllByEstado(Pageable pageable, String estado);
}
