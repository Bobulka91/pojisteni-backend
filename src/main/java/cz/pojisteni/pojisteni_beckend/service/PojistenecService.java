package cz.pojisteni.pojisteni_beckend.service;

import cz.pojisteni.pojisteni_beckend.model.Pojistenec;
import cz.pojisteni.pojisteni_beckend.repository.PojistenecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service                      // říká Springu: toto je servisní třída (business logika)
@RequiredArgsConstructor      // Lombok – vygeneruje konstruktor pro injektování závislostí
public class PojistenecService {

    private final PojistenecRepository repository;

    // Vrátí všechny pojištěnce z databáze
    public List<Pojistenec> findAll() {
        return repository.findAll();
    }

    // Vrátí jednoho pojištěnce podle ID, nebo vyhodí výjimku
    public Pojistenec findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pojištěnec nenalezen"));
    }

    // Uloží nového nebo aktualizuje existujícího pojištěnce
    public Pojistenec save(Pojistenec pojistenec) {
        return repository.save(pojistenec);
    }

    // Smaže pojištěnce podle ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}