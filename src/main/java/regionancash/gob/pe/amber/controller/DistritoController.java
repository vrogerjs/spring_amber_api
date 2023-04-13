package regionancash.gob.pe.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.amber.model.Distrito;
import regionancash.gob.pe.amber.service.IDistritoService;

import java.util.List;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private IDistritoService service;

    @GetMapping
    public List<Distrito> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Distrito>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Distrito> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Distrito readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Distrito create(@RequestBody Distrito distrito) throws Exception {
        return service.create(distrito);
    }

    @PutMapping
    public Distrito update(@RequestBody Distrito distrito) throws Exception {
        return service.update(distrito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
