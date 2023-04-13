package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Provincia;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.repository.IProvinciaRepository;
import regionancash.gob.pe.amber.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl extends CRUDImpl<Provincia, Integer> implements IProvinciaService {
    @Autowired
    private IProvinciaRepository repo;

    @Override
    protected IGenericRepo<Provincia, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Provincia> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
