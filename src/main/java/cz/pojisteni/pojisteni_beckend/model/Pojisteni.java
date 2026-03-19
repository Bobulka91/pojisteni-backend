package cz.pojisteni.pojisteni_beckend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pojisteni")
public class Pojisteni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nazev;        // např. "Pojištění bytu"

    private String typ;          // např. "Životní", "Majetkové"
    private String popis;
    private Double castka;       // výše pojistného

    // Vazba na pojištěnce – mnoho pojištění patří jednomu pojištěnci
    @ManyToOne
    @JoinColumn(name = "pojistenec_id", nullable = false)
    private Pojistenec pojistenec;
}