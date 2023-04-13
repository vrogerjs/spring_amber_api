package regionancash.gob.pe.amber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.amber.model.Persona;
import regionancash.gob.pe.amber.repository.IGenericRepo;
import regionancash.gob.pe.amber.repository.IPersonaRepository;
import regionancash.gob.pe.amber.service.IPersonaService;

import java.util.List;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {
    @Autowired
    private IPersonaRepository repo;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Persona> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public List<Persona> searchByDni(String dni) {
        return repo.searchByDni(dni);
    }
}
