package cz.pojisteni.pojisteni_beckend.controller;

import cz.pojisteni.pojisteni_beckend.model.Pojistenec;
import cz.pojisteni.pojisteni_beckend.service.PojistenecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController                    // říká Springu: tato třída obsluhuje HTTP requesty a vrací JSON
@RequestMapping("/api/pojistenci") // všechny endpointy začínají touto cestou
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // povolí React volat tento controller
public class PojistenecController {

    private final PojistenecService service;

    // GET /api/pojistenci – vrátí seznam všech pojištěnců
    @GetMapping
    public List<Pojistenec> getAll() {
        return service.findAll();
    }

    // GET /api/pojistenci/1 – vrátí jednoho pojištěnce podle ID
    @GetMapping("/{id}")
    public Pojistenec getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /api/pojistenci – vytvoří nového pojištěnce
    @PostMapping
    public Pojistenec create(@RequestBody Pojistenec pojistenec) {
        return service.save(pojistenec);
    }

    // PUT /api/pojistenci/1 – aktualizuje existujícího pojištěnce
    @PutMapping("/{id}")
    public Pojistenec update(@PathVariable Long id, @RequestBody Pojistenec pojistenec) {
        pojistenec.setId(id);
        return service.save(pojistenec);
    }

    // DELETE /api/pojistenci/1 – smaže pojištěnce
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}