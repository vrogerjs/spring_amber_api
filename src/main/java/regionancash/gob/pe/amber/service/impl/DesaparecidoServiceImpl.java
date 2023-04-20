package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Desaparecido;
import regionancash.gob.pe.amber.repository.IDesaparecidoRepository;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.service.IDesaparecidoService;

import java.util.List;
import java.util.Optional;

@Service
public class DesaparecidoServiceImpl extends CRUDImpl<Desaparecido, Integer> implements IDesaparecidoService {
    @Autowired
    private IDesaparecidoRepository repo;

    @Override
    protected IGenericRepo<Desaparecido, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Desaparecido> findAllByEstado(Pageable page, String estado) {
        return repo.findAllByEstado(page, estado);
    }

    public int changeEstado(Integer id, String estado) {
        return repo.changeEstadoOne(id, estado);
    }
}
