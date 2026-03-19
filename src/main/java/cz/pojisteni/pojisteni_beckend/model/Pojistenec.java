package cz.pojisteni.pojisteni_beckend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data                    // Lombok – automaticky vygeneruje gettery, settery, toString
@Entity                  // říká Hibernate: tato třída = databázová tabulka
@Table(name = "pojistenci")
public class Pojistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment v databázi
    private Long id;

    @Column(nullable = false)  // jméno nesmí být null v databázi
    private String jmeno;

    @Column(nullable = false)
    private String prijmeni;

    private int vek;
    private String telefon;
    private String email;
}
