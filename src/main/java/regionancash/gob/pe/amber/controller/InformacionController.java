package regionancash.gob.pe.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.amber.model.Informacion;
import regionancash.gob.pe.amber.service.IInformacionService;

import java.util.List;
@RestController
@RequestMapping("/informacion")
public class InformacionController {
    @Autowired
    private IInformacionService service;

    @GetMapping
    public List<Informacion> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Informacion>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Informacion> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Informacion readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Informacion create(@RequestBody Informacion informacion) throws Exception {
        return service.create(informacion);
    }

    @PutMapping
    public Informacion update(@RequestBody Informacion informacion) throws Exception {
        return service.update(informacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
