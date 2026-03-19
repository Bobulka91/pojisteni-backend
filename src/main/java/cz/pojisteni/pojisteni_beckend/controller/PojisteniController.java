package cz.pojisteni.pojisteni_beckend.controller;

import cz.pojisteni.pojisteni_beckend.model.Pojisteni;
import cz.pojisteni.pojisteni_beckend.service.PojisteniService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pojisteni")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PojisteniController {

    private final PojisteniService service;

    // GET /api/pojisteni?pojistenecId=1 – vrátí pojištění daného pojištěnce
    @GetMapping
    public List<Pojisteni> getByPojistenec(@RequestParam Long pojistenecId) {
        return service.findByPojistenec(pojistenecId);
    }

    // GET /api/pojisteni/1
    @GetMapping("/{id}")
    public Pojisteni getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /api/pojisteni
    @PostMapping
    public Pojisteni create(@RequestBody Pojisteni pojisteni) {
        return service.save(pojisteni);
    }

    // PUT /api/pojisteni/1
    @PutMapping("/{id}")
    public Pojisteni update(@PathVariable Long id, @RequestBody Pojisteni pojisteni) {
        pojisteni.setId(id);
        return service.save(pojisteni);
    }

    // DELETE /api/pojisteni/1
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}