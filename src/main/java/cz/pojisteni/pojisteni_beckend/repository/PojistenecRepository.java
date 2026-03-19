package cz.pojisteni.pojisteni_beckend.repository;

import cz.pojisteni.pojisteni_beckend.model.Pojistenec;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository nám zdarma dává: findAll, findById, save, delete a další
public interface PojistenecRepository extends JpaRepository<Pojistenec, Long> {
}
