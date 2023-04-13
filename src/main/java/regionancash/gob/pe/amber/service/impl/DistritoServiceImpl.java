package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Distrito;
import regionancash.gob.pe.amber.repository.IDistritoRepository;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.service.IDistritoService;

@Service
public class DistritoServiceImpl extends CRUDImpl<Distrito, Integer> implements IDistritoService {
    @Autowired
    private IDistritoRepository repo;

    @Override
    protected IGenericRepo<Distrito, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Distrito> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
