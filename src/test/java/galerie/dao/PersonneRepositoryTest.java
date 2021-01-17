package galerie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class PersonneRepositoryTest {

    @Autowired
    private PersonneRepository personneDAO;

    @Test
    @Sql("test-data-personne.sql") // Chargement spé pour un test
    public void onSaitCompterLesEnregistrements() {

        int combienDansLeJeuDeTest = 1;
        long nombre = personneDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 galerie");
    }

}