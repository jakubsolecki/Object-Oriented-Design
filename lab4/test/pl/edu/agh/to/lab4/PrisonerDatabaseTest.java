package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.dataProviders.PrisonerDatabase;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonerDatabase prisonerDatabase = new PrisonerDatabase();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonerDatabase.getPrisoners().size());
    }
}
