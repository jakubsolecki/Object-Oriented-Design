package pl.edu.agh.to.lab4;

import java.util.Iterator;

public class CitizenDatabaseDecorator implements PersonAggregate{
    private final CitizenDatabase citizenDatabase;

    public CitizenDatabaseDecorator(CitizenDatabase citizenDatabase) {
        this.citizenDatabase = citizenDatabase;
    }

    @Override
    public Iterator<Person> iterator() {
        return citizenDatabase.getCitizens().stream().map(citizen -> (Person) citizen).iterator();
    }
}
