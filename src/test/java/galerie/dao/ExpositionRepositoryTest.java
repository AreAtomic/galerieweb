package galerie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class ExpositionRepositoryTest {

    @Autowired
    private ExpositionRepository expositionDAO;

    @Test
    @Sql("test-data-expo.sql") // Chargement spé pour un test
    public void onSaitCompterLesEnregistrements() {

        int combienDansLeJeuDeTest = 1;
        long nombre = expositionDAO.count();

        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 expo");
    }

}