package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Informacion;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.repository.IInformacionRepository;
import regionancash.gob.pe.amber.service.IInformacionService;

@Service
public class InformacionServiceImpl extends CRUDImpl<Informacion, Integer> implements IInformacionService {
    @Autowired
    private IInformacionRepository repo;

    @Override
    protected IGenericRepo<Informacion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Informacion> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
