package regionancash.gob.pe.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.amber.model.Departamento;
import regionancash.gob.pe.amber.service.IDepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private IDepartamentoService service;

    @GetMapping
    public List<Departamento> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Departamento>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Departamento> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Departamento readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Departamento create(@RequestBody Departamento departamento) throws Exception {
        return service.create(departamento);
    }

    @PutMapping
    public Departamento update(@RequestBody Departamento departamento) throws Exception {
        return service.update(departamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
