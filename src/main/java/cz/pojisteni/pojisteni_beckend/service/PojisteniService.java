package cz.pojisteni.pojisteni_beckend.service;

import cz.pojisteni.pojisteni_beckend.model.Pojisteni;
import cz.pojisteni.pojisteni_beckend.repository.PojisteniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PojisteniService {

    private final PojisteniRepository repository;

    // Vrátí všechna pojištění daného pojištěnce
    public List<Pojisteni> findByPojistenec(Long pojistenecId) {
        return repository.findByPojistenecId(pojistenecId);
    }

    public Pojisteni findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pojištění nenalezeno"));
    }

    public Pojisteni save(Pojisteni pojisteni) {
        return repository.save(pojisteni);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}