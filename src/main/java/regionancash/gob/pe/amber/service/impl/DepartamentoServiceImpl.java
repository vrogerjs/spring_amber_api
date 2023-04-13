package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Departamento;
import regionancash.gob.pe.amber.repository.IDepartamentoRepository;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.service.IDepartamentoService;

@Service
public class DepartamentoServiceImpl extends CRUDImpl<Departamento, Integer> implements IDepartamentoService {
    @Autowired
    private IDepartamentoRepository repo;

    @Override
    protected IGenericRepo<Departamento, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Departamento> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
