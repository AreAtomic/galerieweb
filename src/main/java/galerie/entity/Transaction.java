package galerie.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private LocalDate venduLe;

    @Column(unique = true)
    @NonNull
    private float prixVente;

    @ManyToOne
    Exposition lieuDeVente;

    @OneToOne(mappedBy = "vendu")
    Tableau oeuvre;

    @ManyToOne
    Personne client;

    public float getPrixVente() { return prixVente;
    }

    public LocalDate getVenduLe() {return venduLe;
    }
}