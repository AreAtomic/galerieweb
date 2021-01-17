package galerie.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    public float budgetArt(int annee) {
        float budget = 0f;
        for (Transaction t : achats) {
            LocalDate d = t.getVenduLe();
            if (d.isAfter(LocalDate.of(annee, 1, 1)) && d.isBefore(LocalDate.of(annee, 12, 31))) {
                budget += t.getPrixVente();
            }
        }
        return budget;
    }

    @OneToMany(mappedBy = "client")
    List<Transaction> achats = new LinkedList<>();
}