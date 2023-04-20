package regionancash.gob.pe.amber.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import regionancash.gob.pe.amber.model.Desaparecido;
import java.util.Optional;

public interface IDesaparecidoRepository extends IGenericRepo<Desaparecido, Integer> {
    @Query("SELECT d FROM Desaparecido d WHERE (:estado IS NULL OR d.estado=:estado)")
    Page findAllByEstado(Pageable pageable, String estado);

    @Transactional
    @Modifying
    @Query("UPDATE Desaparecido d SET d.estado=:estado WHERE d.id=:id")
    int changeEstadoOne(Integer id, String estado);
}
