package cz.pojisteni.pojisteni_beckend.repository;

import cz.pojisteni.pojisteni_beckend.model.Pojisteni;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PojisteniRepository extends JpaRepository<Pojisteni, Long> {

    // Spring Data automaticky vytvoří SQL dotaz podle názvu metody
    // SELECT * FROM pojisteni WHERE pojistenec_id = ?
    List<Pojisteni> findByPojistenecId(Long pojistenecId);
}