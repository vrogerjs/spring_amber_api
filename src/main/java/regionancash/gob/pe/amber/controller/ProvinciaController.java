package regionancash.gob.pe.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.amber.model.Provincia;
import regionancash.gob.pe.amber.service.IProvinciaService;

import java.util.List;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController {
    @Autowired
    private IProvinciaService service;

    @GetMapping
    public List<Provincia> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Provincia>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Provincia> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Provincia readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Provincia create(@RequestBody Provincia provincia) throws Exception {
        return service.create(provincia);
    }

    @PutMapping
    public Provincia update(@RequestBody Provincia provincia) throws Exception {
        return service.update(provincia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
