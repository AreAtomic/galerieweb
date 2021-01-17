package galerie.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Artiste extends Personne {

    @Column(unique = true)
    @NonNull
    private String biographie;

    @OneToMany(mappedBy = "auteur")
    List<Tableau> oeuvres = new LinkedList<>();
}