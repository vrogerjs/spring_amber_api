package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Dependencia;
import regionancash.gob.pe.amber.repository.IDependenciaRepository;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.service.IDependenciaService;

@Service
public class DependenciaServiceImpl extends CRUDImpl<Dependencia, Integer> implements IDependenciaService {
    @Autowired
    private IDependenciaRepository repo;

    @Override
    protected IGenericRepo<Dependencia, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Dependencia> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
