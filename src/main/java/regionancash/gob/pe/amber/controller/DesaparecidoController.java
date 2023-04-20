package regionancash.gob.pe.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.amber.model.Desaparecido;
import regionancash.gob.pe.amber.service.IDesaparecidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/desaparecido")
public class DesaparecidoController {
    @Autowired
    private IDesaparecidoService service;

    @GetMapping
    public List<Desaparecido> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Desaparecido>> findAllPagination(
            @PathVariable(value = "from") int from,
            @PathVariable(value = "to") int to,
            @RequestParam(name = "estado", required = false, defaultValue = "0") String estado) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Desaparecido> p = service.findAllByEstado(pageable, estado);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Desaparecido readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Desaparecido create(@RequestBody Desaparecido desaparecido) throws Exception {
        return service.create(desaparecido);
    }

    @GetMapping("/change/{id}")
    public int changeEstado(@PathVariable("id") Integer id, @RequestParam(name = "estado") String estado) throws Exception {
        return service.changeEstado(id, estado);
    }

    @PutMapping
    public Desaparecido update(@RequestBody Desaparecido desaparecido) throws Exception {
        return service.update(desaparecido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
